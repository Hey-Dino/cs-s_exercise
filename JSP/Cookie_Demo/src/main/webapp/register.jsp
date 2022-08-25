<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/25
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>

<body>
    <div class="form-div">
        <div class="reg-content">
            <h1>欢迎注册</h1>
            <span>已有帐号？</span> <a href="login.jsp">登录</a>
        </div>
        <form id="reg-form" action="/registerServlet" method="post">
            <table>
                <tr>
                    <td>用户名</td>
                    <td class="inputs">
                        <input name="username" type="text" id="username"><br>
                        <c:if test="${err}">
                            <span id="username_err" class="err_msg">用户名已存在</span>
                        </c:if>
                    </td>
                </tr>
                <tr>
                    <td>密　码</td>
                    <td class="inputs">
                        <input name="password" type="password" id="password"><br>
                        <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                    </td>
                </tr>
            </table>

            <div class="buttons">
                <input value="注&nbsp;册" type="submit" id="reg_btn">
            </div>
            <!-- <br class="clear"> -->
        </form>
    </div>
</body>
</html>
