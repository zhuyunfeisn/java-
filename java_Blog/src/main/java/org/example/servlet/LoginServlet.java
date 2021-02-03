package org.example.servlet;

import org.example.dao.loginDAO;
import org.example.exception.APPexception;
import org.example.modle.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //数据库校验
       User user= loginDAO.query(username);
        if(user==null){
            throw new APPexception("login002", "用户不存在" );
        }
        if(!user.getPassword().equals(password)){
            throw new APPexception("login003", "用户名或密码错误");
        }
        //登录成功，创建Session
        HttpSession session=req.getSession();
        session.setAttribute("user", user);

//        if(){//模拟用户名密码校验
//          //解析JSONResponse对象中的success就行，不再解析data
//           //返回的值对前端没有影响
//            return null;
//        }else {
//            throw new APPexception("LOG001","用户名或密码错误");
//    }
        return null;
    }
}
