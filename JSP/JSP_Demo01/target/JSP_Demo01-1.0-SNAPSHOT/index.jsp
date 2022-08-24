<%@ page import="com.dino.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Dino
  Date: 2022/8/24
  Time: 10:06
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
    <%
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1, "华为", "华为技术有限公司", 100, "构造万物互联的智能世界", 1));
        brands.add(new Brand(2, "小米", "小米公司", 100, "为发烧而生", 1));
        brands.add(new Brand(3, "大疆创新", "深圳市大疆创新有限公司", 100, "The Future of Possible", 1));
    %>

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
        <tbody>
            <%
                for (Brand brand : brands) {
            %>
            <tr>
                <td><%=brand.getId()%></td>
                <td><%=brand.getBrandName()%></td>
                <td><%=brand.getCompanyName()%></td>
                <td><%=brand.getOrdered()%></td>
                <td><%=brand.getDescription()%></td>
                <td><%=brand.getStatus() == 1 ? "启用" : "禁用"%></td>
                <td><a href="javascript:;" class="editBtn">编辑</a>&nbsp;<a href="javascript:;" class="delBtn">删除</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
