package com.dino.web;

import com.dino.pojo.Brand;
import com.dino.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateBrandServlet")
public class UpdateBrandServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理POST请求乱码问题
        req.setCharacterEncoding("UTF-8");
        // 接收表单提交的数据，封装为Brand对象
        Integer id = Integer.parseInt(req.getParameter("id"));
        String brandName = req.getParameter("brandName");
        String companyName = req.getParameter("companyName");
        Integer ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        Integer status = Integer.parseInt(req.getParameter("status"));
        Brand brand = new Brand(id, brandName, companyName, ordered, description, status);
        // 调用方法，更新品牌信息
        brandService.updateBrand(brand);
        // 请求转发 到selectAllServlet
        req.getRequestDispatcher("/selectAllServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
