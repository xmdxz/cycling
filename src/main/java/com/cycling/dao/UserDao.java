package com.cycling.dao;

import com.cycling.pojo.User;
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

    //根据手机号查询用户
    User selectByPhone(String phone);
}
