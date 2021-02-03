package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.modle.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
      //从前端获取id
       String id=req.getParameter("id");
      //id转化为数据库id
        Article a = ArticleDAO.query(Integer.parseInt(id));
        return a;
    }
}
