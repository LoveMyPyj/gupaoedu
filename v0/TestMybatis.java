package com.gupaoedu.mybatis.newlife.v0;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:44
 * @description:
 */
public class TestMybatis {
    public static void main(String[] args) {
        PSqlSession sqlSession = new PSqlSession(
                new PConfiguration(),
                new PSimpleExecutor()
        );

        TestMapper mapper = sqlSession.getMapper(TestMapper.class);

        com.gupaoedu.mybatis.beans.Test test = mapper.selectByPrimaryKey(1);
        System.out.println(test);
    }
}