package com.cycling.dao;

import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.FansAndFocusDto;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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
     *
     * @param phone 手机号
     * @return User
     */
    User selectByPhone(String phone);

    /**
     * 根据id查询
     *
     * @param  id
     * @return User
     */
    User selectById(Long id);

    /**
     * 根据id主键查询
     *
     * @param id id主键
     * @return User
     */
    UserInfo selectUserInfoById(Long id);

    /**
     * 查找我的界面的头像等级，性别等
     *
     * @param id
     * @return
     */
    OwnInfo getMyInfo(Long id);

    /**
     * 获取用户获赞，关注数等
     *
     * @param id 用户id
     * @return relatedCount
     */
    RelatedCount getRelatedCount(Long id);

    /**
     * 更新用户信息
     *
     * @param id       id
     * @param userInfo userINfo
     * @return int
     */
    int updateInfo(@Param(value = "id") Long id, @Param(value = "userInfo") UserInfo userInfo);

    /**
     * 获取某用户的粉丝
     *
     * @param userId userid
     * @return list
     */
    List<FansAndFocusDto> getFansAndSimpleUserInfo(@Param(value = "userId") Long userId);

    /**
     * 获取某用户的关注
     *
     * @param userId userid
     * @return list
     */
    List<FansAndFocusDto> getFocusedAndSimpleUserInfo(Long userId);

    /**
     * 获取某用户的关注的id
     *
     * @param userId userid
     * @return list
     */
    List<Integer> getFocusedUserId(Long userId);

}
