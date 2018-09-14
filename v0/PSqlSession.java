package com.gupaoedu.mybatis.newlife.v0;

import java.sql.SQLException;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:09
 * @description: 委派模式
 */
public class PSqlSession {
    /**
     * 配置中心
     */
    PConfiguration configuration;
    /**
     * 执行
     */
    PExecutor executor;

    /**
     * 通过构造方法注入
     * @param configuration
     * @param executor
     */
    public PSqlSession(PConfiguration configuration, PExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    /**
     * 通过配置中心获得mapper代理对象
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    /**
     *
     * @param sql sql语句
     * @param parameter 参数
     * @param <T>
     * @return
     */
    public <T> T selectOne(String sql,String parameter) throws SQLException {
        return executor.selectOne(sql,parameter);
    }
}