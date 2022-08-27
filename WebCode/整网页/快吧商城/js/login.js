window.addEventListener("load", function() {
    var lis = document.querySelector('#id1');
    var lis2 = document.querySelector('#id2');
    var id = document.querySelector('.login_id');
    var pwd = document.querySelector('.login_pwd');
    var login = this.document.querySelector('.login_sub');

    console.log(id)
    id.onfocus = function() {
        lis.style.border = "1px solid  rgb(66,166,230)"
        id.placeholder = "邮箱/用户名/手机号";
    }
    id.onblur = function() {
        lis.style.border = "1px solid rgb(187,186,186)"
        if (id.value == "") {
            id.placeholder = "账号不能为空！！！"
        }
    }
    pwd.onfocus = function() {
        pwd.placeholder = "请输入密码";
        lis2.style.border = "1px solid  rgb(66,166,230)"
    }
    pwd.onblur = function() {
        if (pwd.value == "") {
            pwd.placeholder = "密码不能为空！！！"
        }
        lis2.style.border = "1px solid rgb(187,186,186)"
    }
    login.onclick = function() {
        if (id.value == "" || pwd.value == "") {
            alert("账号密码都不能为空！！！")
        } else {
            window.location.href = "index.html";
        }
    }
})