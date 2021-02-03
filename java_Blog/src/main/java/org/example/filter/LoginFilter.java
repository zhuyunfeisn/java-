package org.example.filter;

import org.example.modle.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.annotation.WebFilter;

/**
 * 配置用户统一会话管理的过滤器，匹配所有请求路径
 * 服务端资源：/login不用校验session，其他都要校验，如果不通过，返回401，响应资源随便加
 * 前端资源：/jsp/校验session，不通过重定向到登录页面
 *           /js/,/static/,/view/,全部不校验
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     *每次http请求匹配到过滤器路径时，会执行该过滤器的doFilter方法
     *如果我们要往下执行，是调用filterChain.doFilter(request,response)
     *否则需要自行处理响应内容
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //类强制转换
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse) response;
        String servletPath=req.getServletPath(); //获取当前请求的服务路径
        //先处理不需要登录允许访问的：往下执行,继续调用
        if(servletPath.startsWith("/js/")||servletPath.startsWith("/static/")
        ||servletPath.startsWith("/view/")||servletPath.equals("/login")){
            chain.doFilter(request, response);
        }else {
            //先获取Session对象，没有就返回空
            HttpSession session=req.getSession(false);
           //验证用户是否登录，如果没有登录，还需要根据前端和后端做不同的处理
            if(session==null||session.getAttribute("user")==null){
                //前端重定向到登陆页面
                if(servletPath.startsWith("/jsp/")){
              //使用绝对路径,重定向
                    resp.sendRedirect(basePath(req)+"/view/login.html");
                }else {//后端返回401状态码
                 resp.setStatus(401);
                    //设置请求体的编码
                    resp.setCharacterEncoding("UTF-8");
                    //为响应体设置数据类型（浏览器要采取什么方式执行）
                    resp.setContentType("application/json");
                    JSONResponse json=new JSONResponse();
                    json.setCode("LOG000");
                    json.setMessage("用户没有登录,不允许访问");
                    PrintWriter pw=resp.getWriter();
                    pw.println(JSONUtil.serialize(json));
                    pw.flush();
                    pw.close();
                }
       }else {//敏感资源，但已登录，允许继续执行
                chain.doFilter(request, response);
            }
        }

    }

    /**
     * 根据http请求，动态的获取访问路径（服务路径之前的部分）
     */
    public static String basePath(HttpServletRequest req){
        String schema=req.getScheme();//获取http
        String host=req.getServerName();//主机ip或域名
        int port=req.getServerPort();//服务器端口号
        String contextPath=req.getContextPath();//获取应用上下文路径
        return schema+"://"+host+":"+port+contextPath;
    }
    @Override
    public void destroy() {

    }
}
