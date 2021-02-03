package org.example.dao;

import org.example.exception.APPexception;
import org.example.modle.User;
import org.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class loginDAO {

    public static User query(String username) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try{
            connection=JDBCUtil.getConnection();
            String sql="select id, username, password, sex, birthday,nickname, head from user where username=?";
            statement=connection.prepareStatement(sql);
            //设置占位符
            statement.setString(1, username);
            resultSet=statement.executeQuery();
            User user=null;//先置为空，不然返回时一定有对象
            while (resultSet.next()){
                user=new User();//查出来，有结果集，再新new一个
                //设置user的值
               user.setId(resultSet.getInt("id"));
               user.setUsername(resultSet.getString("username"));
               user.setPassword(resultSet.getString("password"));
               user.setNickname(resultSet.getString("nickname"));
               user.setHead(resultSet.getString("head"));
               user.setSex(resultSet.getBoolean("sex"));
               //关于日期的使用，java中一般使用java.util.Date（年月日，时分秒都带）
               //result.getDate()返回值是java.sql.Date(时分秒)
                //result.getTimestamp()返回值是java.sql.Timestamp（年月日时分秒）
                //类型记得转换
                java.sql.Date birthday=resultSet.getDate("birthday");
                if(birthday!=null)//防止空指针异常
                user.setBirthday(new Date(birthday.getTime()));
            }
            return user;
        }catch (Exception e){
              throw new APPexception("login001", "查询用户操作出错", e);
        }finally {
            JDBCUtil.close(connection, statement, resultSet);
        }
    }
}
