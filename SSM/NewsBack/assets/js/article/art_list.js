$(function () {
    var layer = layui.layer
    var form = layui.form
    var laypage = layui.laypage

    // 定义美化时间的过滤器
    template.defaults.imports.dateFormated = function (date) {
        const dt = new Date(date)

        var y = dt.getFullYear()
        var m = padZero(dt.getMonth() + 1)
        var d = padZero(dt.getDate())

        var hh = padZero(dt.getHours())
        var mm = padZero(dt.getMinutes())
        var ss = padZero(dt.getSeconds())

        return y + '-' + m + '-' + d + ' ' + hh + ':' + mm + ':' + ss
    }
    // 定义补零的函数
    function padZero(n) {
        return n > 9 ? n : '0' + n
    }
    // 将文章状态有数字转化为文字
    template.defaults.imports.stateFormated = function (state) {
        switch (state) {
            case '0':
                return '已发布';
            case '1':
                return '草稿';
        }
    }

    var q = {
        pageNo: 1,     // 页码值，默认请求第一页的数据
        pageSize: 5,    // 每页显示几条数据，默认每页显示2条
        cate_id: undefined,    // 文章分类的 Id
        state: undefined,       // 文章的发布状态
    }
    /* 分页功能 */
    function renderPage(total) {
        // 调用 laypage.render() 方法来渲染分页的结构
        laypage.render({
            elem: 'pageBox',    // 分页容器的 Id
            count: total,       // 总数据条数
            limit: q.pageSize,  // 每页显示几条数据
            curr: q.pageNo,    // 设置默认被选中的分页
            layout: ['count', 'limit', 'prev', 'page', 'next', 'skip'],
            limits: [2, 3, 5, 10],
            /* 
                分页发生切换的时候，触发 jump 回调
                触发 jump 回调的方式有两种：
                1. 点击页码的时候，会触发 jump 回调
                2. 只要调用了 laypage.render() 方法，就会触发 jump 回调 
            */
            jump: function (obj, first) {
                // 把最新的页码值，赋值到 q 这个查询参数对象中
                q.pageNo = obj.curr;
                // 把最新的条目数，赋值到 q 这个查询参数对象的 pageSize 属性中
                q.pageSize = obj.limit;
                // 根据最新的 q 获取对应的数据列表，并渲染表格
                if (!first) {
                    initTable();
                }
            }
        });
    }

    // 初始化文章分类信息
    initCate();
    // 初始化文章信息
    initTable();

    /* 获取文章分类信息 */
    function getCategories() {
        let categories = [];

        $.ajax({
            method: 'GET',
            url: '/my/article/cates',
            async: false,
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('获取分类数据失败！');
                }

                categories = res;
            }
        })

        return categories;
    }

    /* 初始化文章分类信息 */
    function initCate() {
        // 获取文章分类信息
        const categories = getCategories();
        // 将输入引入模板引擎
        var htmlStr = template('tpl-cate', categories);
        // 渲染模板引擎
        $('[name=cate_id]').html(htmlStr);
        // 通过 layui 重新渲染表单区域的UI结构
        form.render();
    }
    /* 获取文章列表数据的方法 */
    function initTable() {
        $.ajax({
            method: 'GET',
            url: '/my/article/list',
            data: q,
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('获取文章列表失败！')
                }

                // 使用模板引擎渲染页面的数据
                var htmlStr = template('tpl-table', res)
                $('tbody').html(htmlStr);
                // 调用渲染分页的方法
                renderPage(res.total)
            }
        })
    }

    /* 筛选表单 */
    $('#form-search').on('submit', function (e) {
        // 阻止表单默认事件
        e.preventDefault();

        // 获取表单中选中项的值
        q.cate_id = $('[name=cate_id]').val();
        q.state = $('[name=state]').val();

        // 根据最新的筛选条件，重新渲染表格的数据
        initTable();
    })

    /* 删除文章（使用事件委托） */
    $('tbody').on('click', '.btn-delete', function () {
        // 获取到文章的 id（借助自定义属性）
        const id = $(this).attr('data-id');
        // 询问用户是否要删除数据
        layer.confirm('确认删除?', { icon: 3, title: '提示' }, function (index) {
            $.ajax({
                method: 'GET',
                url: '/my/article/delete/' + id,
                success: function (res) {
                    if (res.status !== 200) {
                        return layer.msg('删除文章失败！')
                    }
                    layer.msg('删除文章成功！');

                    /* 
                        当数据删除完成后，需要判断当前这一页中，是否还有剩余的数据
                        如果没有剩余的数据了,则让页码值 -1 之后,
                        再重新调用 initTable 方法 
                    */
                    // 获取删除按钮的个数
                    const len = $('.btn-delete').length;
                    if (len === 1) {
                        /* 
                            如果 len 的值等于1，证明删除完毕之后，页面上就没有任何数据了
                            页码值最小必须是 1 
                        */
                        q.pageNo = q.pageNo === 1 ? 1 : q.pageNo - 1
                    }
                    initTable()
                }
            })

            // 关闭对话框
            layer.close(index);
        })
    });

    /* 更新文章 */
    let editBox = null;
    $('tbody').on('click', '.btn-edit', function () {
        editBox = layer.open({
            type: 1,
            area: ['500px', '450px'],
            title: '修改文章信息',
            content: $('#dialog-edit').html(),
        })

        // 获取文章ID
        const articleId = $(this).attr('data-id');
        // 获取文章信息（根据ID查询）
        $.ajax({
            method: 'GET',
            url: `/my/article/${articleId}`,
            success: function (res) {
                if (res.status === 200) {
                    // 获取文章分类信息
                    const categories = getCategories();
                    // 由模板引擎生成结构字符串（通过文章分类信息动态生成）
                    const htmlStr = template('edit-cate', categories);
                    // 渲染结构
                    $('#form-edit [name=cate_id]').html(htmlStr);

                    // 渲染对话框内容（渲染结果为最终显示样式）
                    form.val('form-edit', res.data);
                }
            }
        });
    });
    $('body').on('submit', '#form-edit', function (e) {
        // 阻止表单的默认事件
        e.preventDefault();

        $.ajax({
            method: 'POST',
            url: '/my/article/updateArticle',
            data: $(this).serialize(),
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('更新文章数据失败！');
                }

                layer.msg('更新文章数据成功！');
                // 关闭对话框
                layer.close(editBox);
                // 更新文学分类信息
                initTable();
            }
        })
    })
})