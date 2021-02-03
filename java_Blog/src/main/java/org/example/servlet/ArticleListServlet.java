package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.APPexception;
import org.example.modle.Article;
import org.example.modle.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp)  {
        //获取session，如果没有，返回null
        HttpSession session=req.getSession(false);
        if(session==null)
            throw new APPexception("ATR002", "用户没有登录，不允许访问" );
        //获取登录时创建的session保存的用户信息
        User user =(User)session.getAttribute("user");
        if(user==null)
            throw new  APPexception("ART003", "会话异常，请重新登录");
        //用户已登录，并且保存了用户信息
        List<Article> articles= ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
