package com.xu.mybatis.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class GetSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static GetSqlSessionFactory getSqlSessionFactory=null;
    public  GetSqlSessionFactory() throws IOException {
        String resource="configuration.xml";
        Reader reader=Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(reader);
        SqlSession session=factory.openSession();
    }
}
