package com.gupaoedu.mybatis.newlife.v0;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:10
 * @description: 配置中心
 */
public class PConfiguration {

    /**
     * 配置中心通过动态代理获得mapper对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz,PSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new PMapperProxy(sqlSession)
        );
    }

    /**
     * 此类当成解析完成的xml文件
     */
    static class TestMapperXml{
        /**
         * 命名空间
         */
        static final String NAME_SPACE = "com.gupaoedu.mybatis.newlife.v0.TestMapper";
        /**
         * 注册中心，存放 sql
         */
        static final Map<String,String> sqlMapping = new HashMap<>();

        /**
         * 加载时，初始化解析xml，放入注册器中，存放解析的Mapper和对应的id即方法名
         */
        static {
            sqlMapping.put("selectByPrimaryKey","select * from test where id =%d");
        }
    }
}