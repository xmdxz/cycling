package com.cycling.service;

import com.cycling.pojo.User;

public interface UserService {

    User findByPhone(String phone);
}
