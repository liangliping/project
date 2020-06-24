package com.example.demo.dao.login;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Description: LoginDao <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 9:02 <br>
 */
@Mapper
public interface LoginDao {

    /**
     * 测试数据库
     * @return
     */
    @Select("select id from testDB where id = 1")
    int queryTest();
}
