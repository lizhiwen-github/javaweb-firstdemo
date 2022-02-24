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
import java.util.List;
/**
 * @Classname ${NAME}
 * @Description TODO
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 13:43
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
        List<Brand> list = BrandService.selectAll();
        String jsonString = JSON.toJSONString(list);
        System.out.println("select已执行");
        response.getWriter().write(jsonString);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
