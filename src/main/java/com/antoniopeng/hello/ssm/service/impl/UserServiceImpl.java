package com.antoniopeng.hello.ssm.service.impl;

import com.antoniopeng.hello.ssm.dao.UserDao;
import com.antoniopeng.hello.ssm.entity.User;
import com.antoniopeng.hello.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user != null) {
            // 明文密码加密
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());

            // 判断加密后的密码和数据库中存放的密码是否匹配，匹配则表示允许登录
            if (md5Password.equals(user.getPassword())) {
                return user;
            }
        }

        return null;
    }
}
