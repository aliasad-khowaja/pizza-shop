package org.pizzashop.rest.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class MyBatisUtil {

    private static SqlSessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
