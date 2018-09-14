package com.gupaoedu.mybatis.newlife.v0;

import com.gupaoedu.mybatis.beans.Test;

/**
 * @auther: 彭元具
 * @date: 9/14/2018 11:27
 * @description:
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer id);
}