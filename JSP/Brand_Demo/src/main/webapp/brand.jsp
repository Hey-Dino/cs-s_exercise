<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
        #addBrand {
            display: block;
            width: 100px;
            height: 30px;
            line-height: 30px;
            border: 1px solid #333;
            text-align: center;
        }
        table {
            width: 90%;
            margin: 0 auto;
        }
        table, th, td {
            border: 1px solid #333;
        }
    </style>
</head>
<body>
    <a href="addBrand.jsp" id="addBrand">新增</a>
    <hr>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>品牌名称</th>
            <th>公司名称</th>
            <th>公司排序</th>
            <th>品牌口号</th>
            <th>公司状态</th>
            <th>其他操作</th>
        </tr>
        </thead>
        <c:forEach items="${brands}" var="brand">
            <tr align="center">
                <td>${brand.getId()}</td>
                <td>${brand.getBrandName()}</td>
                <td>${brand.getCompanyName()}</td>
                <td>${brand.getOrdered()}</td>
                <td>${brand.getDescription()}</td>
                <c:if test="${brand.getStatus() == 1}">
                    <td>启用</td>
                </c:if>
                <c:if test="${brand.getStatus() != 1}">
                    <td>禁用</td>
                </c:if>
                <td><a href="updateBrandServlet?id=${brand.getId()}" class="editBtn">编辑</a>&nbsp;<a href="delBrandServlet?id=${brand.getId()}" class="delBtn">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <script>
        var editBtns = document.querySelectorAll(".editBtn");
        for (var i = 0; i < editBtns.length; i++) {
            editBtns[i].addEventListener("click", function (e) {
                var id = this.parentNode.parentNode.children[0].innerText;

            })
        }
    </script>
</body>
</html>
