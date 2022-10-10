$(function () {
    var layer = layui.layer;
    var form = layui.form;
    const laypage = layui.laypage;

    /* 分页功能 */
    const q = {
        pageNo: 1,      // 页码
        pageSize: 5,    // 每页记录数
    }
    function renderPage(total) {
        laypage.render({
            elem: 'pageBox',
            count: total,
            limit: q.pageSize,
            curr: q.pageNo,
            layout: ['count', 'limit', 'prev', 'page', 'next', 'skip'],
            limits: [3, 5, 10],
            jump: function (obj, first) {
                q.pageNo = obj.curr;
                q.pageSize = obj.limit;
                // 判断是否为首次执行，首次执行无需重新更新列表数据
                if (!first) {
                    initTable();
                }
            }
        });
    }

    // 初始化文章分类信息
    initTable()

    /* 获取文章分类的列表 */
    function initTable() {
        $.ajax({
            method: 'POST',
            url: '/my/article/cates',
            data: q,
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('获取文章数据失败！');
                }

                // 生成结构字符串
                var htmlStr = template('tpl-table', res)
                // 渲染表单信息
                $('tbody').html(htmlStr);
                // 调用方法渲染分页结构
                renderPage(res.total);
            }
        })
    }

    /* 为添加类别按钮绑定点击事件 */
    var indexAdd = null
    $('#btnAddCate').on('click', function () {
        indexAdd = layer.open({
            type: 1,
            area: ['500px', '250px'],
            title: '添加文章分类',
            content: $('#dialog-add').html()
        })
    });
    /* 通过代理的形式，为 form-add 表单绑定 submit 事件 */
    $('body').on('submit', '#form-add', function (e) {
        // 阻止表单默认行为
        e.preventDefault();
        // 发送请求
        $.ajax({
            method: 'POST',
            url: '/my/article/addcates',
            data: $(this).serialize(),
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('新增分类失败！')
                }

                layer.msg('新增分类成功！')
                // 更新表单数据
                initTable();
                // 根据索引，关闭对应的弹出层
                layer.close(indexAdd);
            }
        })
    });

    /* 通过代理的形式，为 btn-edit 按钮绑定点击事件 */
    var indexEdit = null
    $('tbody').on('click', '.btn-edit', function () {
        // 弹出一个修改文章分类信息的层
        indexEdit = layer.open({
            type: 1,
            area: ['500px', '250px'],
            title: '修改文章分类',
            content: $('#dialog-edit').html()
        })

        // 发起请求获取对应分类的数据
        var id = $(this).attr('data-id')
        $.ajax({
            method: 'GET',
            url: `/my/article/cates/${id}`,
            success: function (res) {
                form.val('form-edit', res.data)
            }
        })
    });
    /* 通过代理的形式，为修改分类的表单绑定 submit 事件 */
    $('body').on('submit', '#form-edit', function (e) {
        // 阻止表单默认事件
        e.preventDefault();

        $.ajax({
            method: 'POST',
            url: '/my/article/updatecate',
            data: $(this).serialize(),
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('更新分类数据失败！')
                }

                layer.msg('更新分类数据成功！')
                // 更新文章分类信息
                initTable()
                // 关闭对话框
                layer.close(indexEdit);
            }
        })
    });

    /* 通过代理的形式，为删除按钮绑定点击事件 */
    $('tbody').on('click', '.btn-delete', function () {
        var id = $(this).attr('data-id')
        // 提示用户是否要删除
        layer.confirm('确认删除?', { icon: 3, title: '提示' }, function (index) {
            $.ajax({
                method: 'GET',
                url: '/my/article/deletecate/' + id,
                success: function (res) {
                    if (res.status !== 200) {
                        return layer.msg('删除分类失败！')
                    }

                    layer.msg('删除分类成功！');
                    // 更新文章分类信息
                    initTable();
                    // 关闭对话框
                    layer.close(index);
                }
            })
        })
    });
});