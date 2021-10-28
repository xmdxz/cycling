package com.cycling.service;

import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;

/**
 * @author xpdxz
 */
public interface UserService {

    /**
     * 根据手机号查找用户登录信息
     * @param phone 手机号
     * @return user
     */
    User findByPhone(String phone);


    /**
     * 根据id主键查询
     * @return  User
     */
    UserInfo selectUserInfoById();

    /**
     * 查找我的界面的头像等级，性别等
     * @param id
     * @return
     */
    OwnInfo getMyInfo();

    /**
     * 获取用户相关粉丝数
     * @return
     */
    RelatedCount getRelatedCount();

    /**
     * 更新用户信息
     * @param userInfo
     * @return
     */
    int updateInfo(UserInfo userInfo);

}
