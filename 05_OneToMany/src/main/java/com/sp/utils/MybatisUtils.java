package com.sp.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //加载配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");

            //通过配置文件构建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取SqlSession
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }

}
