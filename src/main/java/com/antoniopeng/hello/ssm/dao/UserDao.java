package com.antoniopeng.hello.ssm.dao;

import com.antoniopeng.hello.ssm.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    User selectByUsername(@Param("username") String username);
}
