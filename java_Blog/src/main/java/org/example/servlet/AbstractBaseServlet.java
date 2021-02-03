package org.example.servlet;

import org.example.exception.APPexception;
import org.example.modle.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public  abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求体编码
        req.setCharacterEncoding("UTF-8");
        //设置请求体的编码
        resp.setCharacterEncoding("UTF-8");
        //为响应体设置数据类型（浏览器要采取什么方式执行）
        resp.setContentType("application/json");

        //获取当前URL,校验是否是登录或者注册，如果不是，进行session校验
        //session会话管理，除登录和注册接口，其他都需要登录后访问
        //通过req.getServletPath();获取请求服务路径


        JSONResponse json=new JSONResponse();
        //调用子类重写的方法
        try{

            Object data=process(req, resp);
            //子类的process执行完全没有抛异常，表示业务执行成功
            json.setSuccess(true);
            json.setData(data);

        }catch (Exception e){
            e.printStackTrace();
            //异常如何处理
            //自定义异常返回错误信息
            //json.setSuccess(false)不用设置了，因为new的时候初始化就是
            String code="UNKNOWN";
            String s="未知错误";
            if(e instanceof APPexception){
                //将异常信息取出赋给s
                code=((APPexception)e).getCode();
                s=e.getMessage();
                json.setCode(code);
                json.setMessage(s);
            }
        }
        PrintWriter pr=resp.getWriter();
        //将json信息打印
        pr.println(JSONUtil.serialize(json));
        pr.flush();
        pr.close();
    }

    protected  abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;


}

