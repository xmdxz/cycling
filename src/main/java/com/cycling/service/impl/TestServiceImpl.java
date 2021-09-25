package com.cycling.service.impl;

import com.cycling.dao.TestDao;
import com.cycling.dto.Student;
import com.cycling.service.TestService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xpdxz
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Date 2021/9/25 20:33
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestDao testDao;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public List<Student> getList() {
        redisTemplate.opsForValue().set("123",testDao.getStudentList());
        return testDao.getStudentList();
    }
}
