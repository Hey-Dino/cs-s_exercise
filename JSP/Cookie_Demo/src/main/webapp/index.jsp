<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        html,body {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100%;
            height: 100%;
            background-color: rgba(255, 255, 255, .5);
        }

        h1 {
            font-size: 50px;
            color: #333;
        }
    </style>
</head>

<body>
    <h1>${user.getUsername()}，欢迎您使用本系统！</h1>
    <%--<h2>Hello World!</h2>
    <h2>This is the Page of Cookie_Demo Module.</h2>--%>
</body>

</html>
