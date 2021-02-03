package org.example.servlet;

import org.example.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;


/**
 * 做图片上传UEditor富文本编辑器图片上传
 * 1.修改idea中tomcat配置的应用上下文路径，maven中的finalName
 * 2.修改webapp/static/ueditor.config.js，33行修改应用上下文路径和服务路径
 * 3.实现后端接口（和第二步的服务路径要一致）
 */
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     //通过一个类加载器，使用相对位置，查找一个资源
        URL url=UEditorServlet.class.getClassLoader().getResource("config.json");
       //URL获取到时，都是编码后的字符串，使用时都需要解码
        String path= URLDecoder.decode(url.getPath(), "UTF-8");
        //框架提供的富文本编辑器上传功能
        MyActionEnter enter=new MyActionEnter(req, path);
        String exec=enter.exec();//执行,返回为字符串，响应给前端使用
        PrintWriter pw=resp.getWriter();
        pw.println(exec);
        pw.flush();
        pw.close();





    }
}
