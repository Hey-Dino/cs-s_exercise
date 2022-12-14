$(function () {
    $('.layui-form').on('submit', function (e) {
        // 阻止表单的默认行为
        e.preventDefault();

        // 发送Ajax请求，更新用户密码
        $.ajax({
            method: 'POST',
            url: '/my/updatepwd',
            data: {
                newPwd: $('[name=password]').val(),
            },
            success: function (res) {
                if (res.status !== 200) {
                    return layui.layer.msg('更新密码失败！');
                }
                layui.layer.msg('更新密码成功！');
                // 清空本地存储中的 token
                localStorage.removeItem('token')
                // 重新跳转到登录页面
                window.parent.location.pathname = '/login.html'
            }
        })
    })
})
