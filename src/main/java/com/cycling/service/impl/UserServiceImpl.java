package com.cycling.service.impl;

import com.cycling.dao.UserDao;
import com.cycling.pojo.User;
import com.cycling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: qyz
 * @date: 2021/10/20 13:27
 * @Version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findByPhone(String phone) {
        return userDao.selectByPhone(phone);
    }
}
