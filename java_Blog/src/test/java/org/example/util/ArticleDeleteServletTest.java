package org.example.util;

import org.example.dao.ArticleDAO;
import org.junit.Test;

public class ArticleDeleteServletTest {
    @Test
    public void ArticleDeleteServletTest(){
        Integer integer= ArticleDAO.delete("4,5".split(","));
        System.out.println(integer);
    }
}
