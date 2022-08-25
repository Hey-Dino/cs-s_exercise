package com.dino.web;

import com.dino.pojo.Brand;
import com.dino.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求参数中获取 品牌ID
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 根据品牌ID，查询品牌信息
        Brand brand = brandService.selectById(id);
        // 将查询到的品牌信息，插入到请求中
        req.setAttribute("brand", brand);
        // 携带品牌信息，将请求转发到 updateBrand.jsp
        // updateBrand.jsp 可以根据该品牌信息，绘制页面
        req.getRequestDispatcher("/updateBrand.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
