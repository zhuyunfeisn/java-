package org.example.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class JDBCUtilTest extends JDBCUtil{
   @Test
    public void JDBCUtilTest(){
       Connection connection=getConnection();
       Assert.assertNotNull(connection);
   }
}
