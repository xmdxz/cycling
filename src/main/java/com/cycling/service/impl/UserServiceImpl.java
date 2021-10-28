package com.cycling.service.impl;

import com.cycling.dao.UserDao;
import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.service.UserService;
import com.cycling.utils.RequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: qyz
 * @date: 2021/10/20 13:27
 * @Version: V1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User findByPhone(String phone) {
        return userDao.selectByPhone(phone);
    }

    @Override
    public UserInfo selectUserInfoById() {
        return userDao.selectUserInfoById(1L);
    }

    @Override
    public OwnInfo getMyInfo() {
        return userDao.getMyInfo(getUserId());
    }

    private Long getUserId(){
        return Long.parseLong(Objects.requireNonNull(RequestUtil.getRequestValue("id")));
    }
}
