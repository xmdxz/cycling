package com.cycling.dao;

import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.OwnInfo;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserDao
 * @Description: TODO
 * @Author: qyz
 * @date: 2021/10/20 13:13
 * @Version: V1.0
 */

@Repository
public interface UserDao {

    /**
     * 根据手机号查询
     * @param phone 手机号
     * @return User
     */
    User selectByPhone(String phone);

    /**
     * 根据id主键查询
     * @param id id主键
     * @return  User
     */
    UserInfo selectUserInfoById(Long id);

    /**
     * 查找我的界面的头像等级，性别等
     * @param id
     * @return
     */
    OwnInfo getMyInfo(Long id);
}
