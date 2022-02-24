package com.lzw.web.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
/**
 * @Classname BaseServlet
 * @Description TODO 替换HttpServlet，根据请求的最后一段路径来进行方法分发
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/19 18:16
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求路径
        String requestURI = request.getRequestURI();// /finalBrandDemo/brand/selectAll
        //获取uri中最后一个字符串--表示要访问的方法名
        int index = requestURI.lastIndexOf("/");//获取最后一个/所在的下标
        String methodName = requestURI.substring(index + 1);
        //执行对应的方法
        //1、获取BrandServlet的字节码对象 Class
        //此处的this表示BrandServlet所在的this
        Class<? extends BaseServlet> cls = this.getClass();
        //2、获取方法Method对象
        try {
            Method method=cls.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
