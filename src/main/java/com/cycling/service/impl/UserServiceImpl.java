package com.cycling.service.impl;

import com.cycling.dao.UserDao;
import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.FansAndFocusDto;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;
import com.cycling.service.UserService;
import com.cycling.utils.RequestUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        return userDao.selectUserInfoById(RequestUtil.getUserId());
    }

    @Override
    public OwnInfo getMyInfo() {
        return userDao.getMyInfo(RequestUtil.getUserId());
    }

    @Override
    public RelatedCount getRelatedCount() {
        return userDao.getRelatedCount(RequestUtil.getUserId());
    }

    @Override
    public int updateInfo(UserInfo userInfo) {
        return userDao.updateInfo(RequestUtil.getUserId(), userInfo);
    }

    @Override
    public List<FansAndFocusDto> getFansAndSimpleUserInfo() {
        return userDao.getFansAndSimpleUserInfo(RequestUtil.getUserId());
    }

    @Override
    public List<FansAndFocusDto> getFocusedAndSimpleUserInfo() {
        return userDao.getFocusedAndSimpleUserInfo(RequestUtil.getUserId());
    }

    @Override
    public List<Integer> getFocusedUserId() {
        return userDao.getFocusedUserId(RequestUtil.getUserId());
    }


}
