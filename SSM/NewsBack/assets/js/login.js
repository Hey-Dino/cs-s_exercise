$(function () {
    // 点击“去注册账号”的链接
    $('#link_reg').on('click', function () {
        $('.login-box').hide();
        $('.reg-box').show();
    })

    // 点击“去登录”的链接
    $('#link_login').on('click', function () {
        $('.login-box').show();
        $('.reg-box').hide();
    })

    // 创建 layUI 提示实例
    var layer = layui.layer;

    // 监听注册表单的提交事件
    $('#form_reg').on('submit', function (e) {
        // 1.阻止默认的提交行为
        e.preventDefault();
        // 2.发起Ajax的POST请求
        $.ajax({
            method: 'POST',
            url: '/api/reguser',
            data: {
                username: $('#form_reg [name=username]').val(),
                password: $('#form_reg [name=password]').val(),
            },
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('注册失败！');
                }
                layer.msg('注册成功，请登录！');

                // 模拟人的点击行为，跳转登录页面
                $('#link_login').click();
            }
        });
    });

    // 监听登录表单的提交事件
    $('#form_login').submit(function (e) {
        // 1.阻止默认提交行为
        e.preventDefault();
        // 2.发起Ajax的请求
        $.ajax({
            method: 'POST',
            url: '/api/login',
            // 快速获取表单中的数据
            data: $(this).serialize(),
            success: function (res) {
                if (res.status !== 200) {
                    return layer.msg('登录失败！')
                }

                layer.msg('登录成功！')
                // 存储身份认证令牌 Token
                localStorage.setItem('token', res.token)
                // 跳转到后台主页
                location.href = './index.html'
            }
        });
    });
})