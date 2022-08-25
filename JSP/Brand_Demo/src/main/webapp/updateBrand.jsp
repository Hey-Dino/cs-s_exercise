<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/24
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>更新数据</title>
</head>
<body>
<h3>修改品牌信息</h3>
<form action="/Brand_Demo_war/updateBrandServlet" method="post">
    <table>
        <input type="hidden" name="id" value="${brand.getId()}"/>
        <tr>
            <td>品牌名称:</td>
            <td><input name="brandName" value="${brand.getBrandName()}"></td>
        </tr>
        <tr>
            <td>企业名称:</td>
            <td><input name="companyName" value="${brand.getCompanyName()}"></td>
        </tr>
        <tr>
            <td>排序：</td>
            <td><input type="number" name="ordered" value="${brand.getOrdered()}"></td>
        </tr>

        <tr>
            <td>描述信息：</td>
            <td><textarea rows="5" cols="20" name="description">${brand.getDescription()}</textarea></td>
        </tr>

        <tr>
            <td>状态：</td>
            <td>
                <c:if test="${brand.getStatus() != 1}">
                    <input type="radio" name="status" value="0" checked>禁用
                    <input type="radio" name="status" value="1">启用<br>
                </c:if>
                <c:if test="${brand.getStatus() == 1}">
                    <input type="radio" name="status" value="0" >禁用
                    <input type="radio" name="status" value="1" checked>启用<br>
                </c:if>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
