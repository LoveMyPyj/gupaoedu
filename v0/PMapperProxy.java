package com.gupaoedu.mybatis.newlife.v0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:16
 * @description: mapper代理
 */
public class PMapperProxy implements InvocationHandler {

    private PSqlSession sqlSession;

    /**
     * 构造方法注入
     * @param sqlSession
     */
    public PMapperProxy(PSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * mapper的代理增强，在代理执行时候操作得到数据
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //得到接口方法的类的名称 与namespace做比较
        if (method.getDeclaringClass().getName().equals(PConfiguration.TestMapperXml.NAME_SPACE)){
            //取出sql语句，并放入查询参数
            String sql = PConfiguration.TestMapperXml.sqlMapping.get(method.getName());
            return sqlSession.selectOne(sql,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}