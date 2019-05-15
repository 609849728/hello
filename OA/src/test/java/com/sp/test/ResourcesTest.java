package com.sp.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:applicationContext.xml")
public class ResourcesTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SqlSessionFactoryBean sqlSessionFactoryBean;

    @Test
    public void testDataSource() {
        System.out.println(dataSource);
    }

    @Test
    public void testSqlSessionFactoryBean() {
        System.out.println(sqlSessionFactoryBean);
    }

}
