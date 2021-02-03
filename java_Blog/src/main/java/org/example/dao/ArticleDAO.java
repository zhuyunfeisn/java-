package org.example.dao;

import org.example.exception.APPexception;
import org.example.modle.Article;
import org.example.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) {
        List<Article> articles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select  id,title from article where user_id=?";
            statement = connection.prepareStatement(sql);
            //设置占位符
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                //结果集取值设置到文章对象中
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                articles.add(article);
                System.out.println(article.toString());
            }
            return articles;

        } catch (Exception e) {
            throw new APPexception("ART001", "查询文章列表出错");
        } finally {
            JDBCUtil.close(connection, statement, resultSet);
        }

    }

    public static int delete(String[] split) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in (");
            for (int i = 0; i <split.length ; i++) {
                if(i!=0)
                    sql.append(",");
                sql.append("?");
            }
            sql.append(")");
            statement = connection.prepareStatement(sql.toString());
            //设置占位符(动态设置)
            for (int i = 0; i <split.length ; i++) {
                statement.setInt(i+1,Integer.parseInt(split[i]) );
            }

            return statement.executeUpdate();
        } catch (Exception e) {
            throw new APPexception("ART004", "文章删除操作出错", e);

        } finally {
                  JDBCUtil.close(connection, statement);
        }
    }

    public static int insert(Article a) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=JDBCUtil.getConnection();
            String sql="insert into article(title,content,user_id) values\n" +
                    "(?,?,?);";
            statement=connection.prepareStatement(sql);
            //设置占位符
            statement.setString(1, a.getTitle());
            statement.setString(2, a.getContent());
            statement.setInt(3, a.getUserId());
            return statement.executeUpdate();

    }catch (Exception e){
            throw new APPexception("ART005","文章插入操作出错",e);
        }finally {
            JDBCUtil.close(connection, statement );
        }

        }

    public static Article query(int id) {
    Connection connection=null;
    PreparedStatement statement=null;
    ResultSet resultSet=null;
    try{
        connection=JDBCUtil.getConnection();
        String sql="select id,title,content from article where id=?";
        statement=connection.prepareStatement(sql);
        //设置占位符
        statement.setInt(1, id);
        resultSet=statement.executeQuery();
        Article article=null;
        while (resultSet.next()){
            article=new Article();
            //根据结果集设置文章属性
            article.setId(resultSet.getInt("id"));
            article.setTitle(resultSet.getString("title"));
            article.setContent(resultSet.getString("content"));
        }
    return article;
    }catch (Exception e){
        throw new APPexception("ART006", "查询文章详情操作出错",e);
    }finally {
 JDBCUtil.close(connection, statement, resultSet);
    }
    }

    public static int update(Article a) {
        Connection connection=null;
        PreparedStatement statement=null;
        try{
           connection=JDBCUtil.getConnection();
           String sql="update article set title=?,content=? where id=?";
           statement=connection.prepareStatement(sql);
           //设置占位符
          statement.setString(1, a.getTitle());
          statement.setString(2, a.getContent());
          statement.setInt(3, a.getId());
          return statement.executeUpdate();
        }catch (Exception e){
            throw new APPexception("ART007","修改文章操作出错",e);
        }finally {
            JDBCUtil.close(connection, statement );
        }
    }
}
