package com.gupaoedu.mybatis.newlife.v0;

import java.sql.SQLException;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:10
 * @description: 执行查询
 */
public interface PExecutor {
    <T> T selectOne(String sql, String parameter) throws SQLException;
}