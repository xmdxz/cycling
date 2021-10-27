package com.cycling.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

/**
 * @ClassName: SaltUtil
 * @Description: TODO
 * @Author: qyz
 * @date: 2021/10/20 21:06
 * @Version: V1.0
 */
public class SaltUtil {

    /*
     * 生成盐的静态方法
     */
    public static String getSalt(int n) {

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder salt=new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            salt.append(aChar);
        }
         
        return salt.toString();
    }

    //测试
    public static void main(String[] args) {
        String salt=SaltUtil.getSalt(8);
        System.out.println(salt);
        Md5Hash md5Hash=new Md5Hash("123","St&hgBGl",1024);
        System.out.println(md5Hash.toHex());
    }
}
