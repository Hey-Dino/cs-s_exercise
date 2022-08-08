window.addEventListener("load", function () {
    const telInput = document.querySelector("#tel");
    const pwd1Input = document.querySelector("#pwd1");
    const pwd2Input = document.querySelector("#pwd2");

    const telError = document.querySelector("#tel-error");
    const pwd1Error = document.querySelector("#pwd1-error");
    const pwd2Error = document.querySelector("#pwd2-error");

    const telReg = /^1[345789][0-9]{9}$/;
    const pwdReg = /^[0-9]{6,18}$/;

    // 监听手机号的输入
    telInput.addEventListener("blur", function () {
        let tel = telInput.value;
        if (tel !== "" && !telReg.test(tel)) {
            telError.style.display = "inline-block";
        } else {
            telError.style.display = "none";
        }
    });

    // 监听登录密码的输入
    pwd1Input.addEventListener("blur", function () {
        let pwd1 = pwd1Input.value;
        if (pwd1 !== "" && !pwdReg.test(pwd1)) {
            pwd1Error.style.display = "inline-block";
        } else {
            pwd1Error.style.display = "none";
        }
    });

    pwd2Input.addEventListener("blur", function () {
        let pwd1 = pwd1Input.value;
        let pwd2 = pwd2Input.value;

        if (pwd2 !== "" && pwd2 !== pwd1) {
            pwd2Error.style.display = "inline-block";
        } else {
            pwd2Error.style.display = "none";
        }
    });
});