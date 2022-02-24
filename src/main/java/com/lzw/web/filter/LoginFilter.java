package com.lzw.web.filter;
import com.lzw.entity.User;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * @Classname LoginFilter 登录过滤器
 * @Description TODO 对非法登录进行过滤
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/27 17:58
 */
@WebFilter("/brand.html")
public class LoginFilter implements Filter {
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request请求进行过滤
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String[] urls = {"/login.html","/img/","/css/","/js/","/selectUsernameAndPassword"};
        // 获取当前访问的资源路径
        String url = request.getRequestURL().toString();
        //循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到了
                //放行
                chain.doFilter(request, response);
                return;
            }
        }
        //当用户登录成功的时候，会将user对象存放在session中
        //当取出session中的值不为空时，表示此时用户已经登录过直接可以跳转到主页面
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("session:"+user);
        if(user!=null){
            chain.doFilter(req, resp);
        }else{
            //用户尚未登录，直接跳转到登录页面
            response.sendRedirect("http://localhost:8080/finalBrandDemo/login.html");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
