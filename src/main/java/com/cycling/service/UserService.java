package com.cycling.service;

import com.cycling.pojo.User;
import com.cycling.pojo.UserInfo;
import com.cycling.pojo.dto.FansAndFocusDto;
import com.cycling.pojo.dto.OwnInfo;
import com.cycling.pojo.dto.RelatedCount;

import java.util.List;

/**
 * @author xpdxz
 */
public interface UserService {

    /**
     * 根据手机号查找用户登录信息
     *
     * @param phone 手机号
     * @return user
     */
    User findByPhone(String phone);

    /**
     * 根据id查找用户登录信息
     *
     * @param id
     * @return user
     */
    User findById(Long id);


    /**
     * 根据id主键查询
     *
     * @return User
     */
    UserInfo selectUserInfoById();

    /**
     * 查找我的界面的头像等级，性别等
     *
     * @param id
     * @return
     */
    OwnInfo getMyInfo();

    /**
     * 获取用户相关粉丝数
     *
     * @return
     */
    RelatedCount getRelatedCount();

    /**
     * 更新用户信息
     *
     * @param userInfo userInfo
     * @return int
     */
    int updateInfo(UserInfo userInfo);


    /**
     * 获取某用户的粉丝
     *
     * @param minId
     * @param num
     * @return
     */
    List<FansAndFocusDto> getFansAndSimpleUserInfo(Long minId, Integer num);

    /**
     * 获取某用户的关注
     *
     * @return list
     */
    List<FansAndFocusDto> getFocusedAndSimpleUserInfo(Long minId, Integer num);

    /**
     * 获取某用户的关注的id
     *
     * @return list
     */
    List<Integer> getFocusedUserId();

    /**
     * 取消关注
     *
     * @param id
     * @return
     */
    Integer cancelFocused(Long id);

    /**
     * 关注
     *
     * @param focusedUserId
     * @return
     */
    Integer focus(Long focusedUserId);

}
