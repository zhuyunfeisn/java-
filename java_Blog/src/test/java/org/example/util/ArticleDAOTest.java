package org.example.util;

import org.example.dao.ArticleDAO;
import org.example.modle.Article;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArticleDAOTest {
    List<Article> list= ArticleDAO.queryByUserId(1);
   @Test
    public void ArticleDAOTest(){
       Assert.assertNotNull(list);
   }
}
