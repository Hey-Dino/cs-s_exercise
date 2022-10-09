$(function () {
    // 从 layui 中获取 form 对象
    var form = layui.form

    // 通过 form.verify() 函数自定义校验规则
    form.verify({
        // 自定义了一个叫做 pwd 校验规则
        pwd: [/^[\S]{6,12}$/, '密码必须6到12位，且不能出现空格'],
        // 校验密码新旧密码是否不同
        samePwd: function (value) {
            if (value === $('[name=oldPassword]').val()) {
                return '新旧密码不能相同！'
            }
        },
        // 校验两次密码是否一致的规则
        rePwd: function (value) {
            if (value !== $('[name=password]').val()) {
                return '两次密码不一致！';
            }
        }
    })
})