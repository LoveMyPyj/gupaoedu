package com.gupaoedu.mybatis.newlife.v0;

import com.gupaoedu.mybatis.beans.Test;

import java.sql.*;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:15
 * @description:
 */
public class PSimpleExecutor implements PExecutor {
    @Override
    public <T> T selectOne(String sql, String parameter){
        Connection conn = null;
        PreparedStatement pstmt = null;
        Test test = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://39.106.2.32:3306/gp?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "123456");
            String msql = String.format(sql, Integer.valueOf(parameter));
            pstmt = conn.prepareStatement(msql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                test = new Test();
                test.setId(resultSet.getInt(1));
                test.setNums(resultSet.getInt(2));
                test.setName(resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (parameter != null){
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T)test;
    }
}