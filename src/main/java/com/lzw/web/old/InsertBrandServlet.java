package com.lzw.web.old;

import com.alibaba.fastjson.JSON;
import com.lzw.entity.Brand;
import com.lzw.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname InsertBrandServlet
 * @Description TODO 接收view层的数据，将其持久化保存在数据库中
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 16:59
 */
@WebServlet("/insertBrandServlet")
public class InsertBrandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String jsonString = request.getReader().readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        //持久化保存数据
        BrandService.insertBrand(brand);
        //向前端响应，持久化成功的标识
        response.getWriter().write("success");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
