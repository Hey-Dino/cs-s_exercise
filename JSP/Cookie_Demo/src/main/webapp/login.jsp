<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/25
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>登录界面</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
    <div id="loginDiv">
        <form action="/loginServlet" method="post" id="form">
            <h1 id="loginMsg">登录系统</h1>
            <p>用户名:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
            <p>密　码:<input id="password" name="password" type="password"  value="${cookie.password.value}"></p>
            <c:if test="${err}">
                <div id="errMsg">用户名或密码不正确</div>
            </c:if>
            <p>
                <c:if test="${cookie.remember.value == \"1\"}">
                    <input id="remember" name="remember" type="checkbox" value="1" checked>
                </c:if>
                <c:if test="${cookie.remember.value != \"1\"}">
                    <input id="remember" name="remember" type="checkbox" value="1">
                </c:if>
                <span id="remPwd">记住密码</span>
                <a href="register.jsp" id="regBtn">没有账号？点击注册</a>
            </p>

            <div id="subDiv">
                <input type="submit" class="button" value="登陆">
                <input type="reset" class="button" value="重置">
            </div>
        </form>
    </div>
</body>

</html>
