package com.cycling.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @ClassName: User
 * @Description: pojo
 * @Author: qyz
 * @date: 2021/10/20 13:07
 * @Version: V1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    //自增主键
    private Integer id;
    //密码
    private String password;
    //登录的方式
    private String method;
    //微信openid
    private String wx_openid;
    //QQ的openid
    private String qq_openid;
    //手机号
    private String phone;
    //账号创建时间
    private Timestamp create_time;
    //账号最后一次登录时间
    private Timestamp last_login_time;
    //盐
    private String salt;
}
