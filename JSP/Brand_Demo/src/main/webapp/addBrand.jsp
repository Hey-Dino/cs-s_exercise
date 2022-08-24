<%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/24
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>添加品牌</h3>
    <form action="/Brand_Demo_war/addBrand" method="post">
        <table>
            <tr>
                <td>品牌名称:</td>
                <td><input name="brandName"></td>
            </tr>
            <tr>
                <td>企业名称:</td>
                <td><input name="companyName"></td>
            </tr>
            <tr>
                <td>排序：</td>
                <td><input name="ordered"></td>
            </tr>

            <tr>
                <td>描述信息：</td>
                <td><textarea rows="5" cols="20" name="description"></textarea></td>
            </tr>

            <tr>
                <td>状态：</td>
                <td><input type="radio" name="status" value="0">禁用<input type="radio" name="status" value="1">启用</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
        </table>
    </form>
</body>
</html>
