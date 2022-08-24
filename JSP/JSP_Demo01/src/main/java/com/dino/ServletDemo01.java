package com.dino;

import com.dino.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1, "华为", "华为技术有限公司", 100, "构造万物互联的智能世界", 1));
        brands.add(new Brand(2, "小米", "小米公司", 100, "为发烧而生", 1));
        brands.add(new Brand(3, "大疆创新", "深圳市大疆创新有限公司", 100, "The Future of Possible", 1));

        req.setAttribute("brands", brands);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
