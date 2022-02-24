package com.lzw.web.servlet;
import com.alibaba.fastjson.JSON;
import com.lzw.entity.Brand;
import com.lzw.entity.PageBean;
import com.lzw.service.BrandService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * @Classname BrandServlet
 * @Description TODO
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 18:59
 */
@WebServlet("/brand/*")
public class BrandServlet  extends BaseServlet{
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/19 19:03
     * @description: TODO 通过service层查询到的所有品牌数据，将其显示到前端页面上
     */
    public void selectAllBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        List<Brand> list = BrandService.selectAll();
        String jsonString = JSON.toJSONString(list);
        System.out.println("select已执行");
        response.getWriter().write(jsonString);
    }
    /**
     * @param request  封装了请求信息的对象
     * @param response 封装了响应信息的对象
     * @return void
     * @author 李志文
     * @date 2022/1/19 19:04
     * @description: TODO  从前端页面获取的数据，将其通过service层持久化保存在数据库中
     */
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String jsonString = request.getReader().readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        //持久化保存数据
        BrandService.insertBrand(brand);
        //向前端响应，持久化成功的标识
        response.getWriter().write("success");
    }
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/20 11:00
     * @description: TODO  从数据中批量删除选定的数据
     */
    public void deleteSome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String jsonString = request.getReader().readLine();
        int[] ids = JSON.parseObject(jsonString, int[].class);
        BrandService.deleteByIds(ids);
        response.getWriter().write("success");
    }
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/20 12:26
     * @description: TODO 获取前端页面传入的当前页码额当前页数，进行分页查询，并将查询到的数据 响应到前端
     */
    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        PageBean pageBean = BrandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(jsonString);
    }
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/23 12:22
     * @description: TODO 条件查询和分页查询的汇总操作，当条件不存在时就是全部查询
     */
    public void selectByPageAndCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //System.out.println("condition执行了");
        request.setCharacterEncoding("utf-8");
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String jsonString = request.getReader().readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        PageBean pageBean = BrandService.selectByPageAndCondition(currentPage, pageSize, brand);
        String jsonString1 = JSON.toJSONString(pageBean);
        response.setContentType("text/html;charset=utf-8");
        System.out.println(jsonString1);
        response.getWriter().write(jsonString1);
    }
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/23 13:31
     * @description: TODO 根据主键id值删除数据
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        BrandService.deleteById(id);
        //删除执行成功，响应查询成功的标识字符串
        response.getWriter().write("success");
    }
    /**
     * @param request 请求对象
     * @param response 响应对象
     * @return void
     * @author 李志文
     * @date 2022/1/23 13:32
     * @description: TODO 根据主键id值获取数据对象
     */
    public void getBrandById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("id="+id);
        Brand brand = BrandService.getBrandById(id);
        String jsonString = JSON.toJSONString(brand);
        System.out.println(jsonString);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String jsonString = request.getReader().readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        BrandService.UpdateBrand(brand);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("success");

    }


}
