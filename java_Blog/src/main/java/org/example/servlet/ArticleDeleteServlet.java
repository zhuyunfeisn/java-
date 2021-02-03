package org.example.servlet;

import org.example.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends AbstractBaseServlet{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
       //ids请求的键值,article的id
        String ids=req.getParameter("ids");
        //字符串分割成字符数组1，2，3，根据1，2，3查找相应文章
         int num= ArticleDAO.delete(ids.split(","));
       return null;
    }
}
