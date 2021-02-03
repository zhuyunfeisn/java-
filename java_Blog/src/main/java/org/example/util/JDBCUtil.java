package org.example.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.example.exception.APPexception;
import org.example.modle.Article;

import javax.sql.DataSource;
import java.sql.*;

public class  JDBCUtil {
    private static final String URL="jdbc:mysql://localhost:3306/servlet_blog?" +
            "user=root&password=sn20000904&useUnicode=true&characterEncoding=UTF-8";

    //数据库连接池
    private static final DataSource DS=new MysqlDataSource();
  //静态代码块初始化DS

    /**
     * 工具类提供数据库JDBC操作
     * 不足：1.static代码块出现错误，NoClassDefFoundError表示类可以找到，但是类加载失败，然后无法运行
     *       和（ClassNotFoundException）：找不到类  区别开
     *       2.学了多线程之后，可能会采取双重校验锁的单例模式来创建DataSource
     *       3.工具类设计上不是最优的，数据库框架ORM框架Mybatis，都是模板模式设计的
     *
     */


    static {
        ((MysqlDataSource)DS).setUrl(URL);
    }
    //获取数据库连接
  public static Connection getConnection(){
      try {
          return DS.getConnection();
      } catch (SQLException e) {
          e.printStackTrace();
          //抛自定义异常
        throw new APPexception("SQL001","获取数据库连接异常",e);
      }
  }
  //资源释放
  public static void close(Connection c, Statement s, ResultSet r){
      try {
          if(r!=null)
              r.close();
          if(s!=null)
              s.close();
          if(c!=null)
              c.close();
      } catch (SQLException e) {
          throw new APPexception("SQL002","数据库释放资源出错",e);
      }
  }
    public static void close(Connection c, Statement s){
           close(c,s ,null );
    }


}
