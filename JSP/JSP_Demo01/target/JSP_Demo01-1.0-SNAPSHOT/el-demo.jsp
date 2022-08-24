<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/24
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        table, th, td {
            border: 1px solid #333;
        }
    </style>
</head>
<body>
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
        <tr>
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
            <td><a href="javascript:;" class="editBtn">编辑</a>&nbsp;<a href="javascript:;" class="delBtn">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
