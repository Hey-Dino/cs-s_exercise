package com.dino.web;

import com.dino.pojo.Brand;
import com.dino.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addBrand")
public class AddBrandServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        Integer ordered =  Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        Integer status = Integer.parseInt(req.getParameter("status"));

        // 添加品牌
        brandService.addBrand(new Brand(0, brandName, companyName, ordered, description, status));

        // 请求转发
        req.getRequestDispatcher("/SelectAllServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
