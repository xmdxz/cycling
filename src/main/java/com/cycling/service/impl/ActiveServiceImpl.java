package com.cycling.service.impl;

import com.cycling.dao.ActiveDao;
import com.cycling.pojo.Active;
import com.cycling.service.ActiveService;
import com.cycling.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/10/28 20:27
 */
@Service
public class ActiveServiceImpl implements ActiveService {
    @Resource
    private ActiveDao activeDao;

    @Override
    public ResponseResult insert(Active active) {
        int i = activeDao.insert(active);
        if (i != 0)  return ResponseResult.ok();
        return  ResponseResult.error("服务器错误，请稍后重试");
    }

    @Override
    public ResponseResult getAllActive() {
        return ResponseResult.ok(activeDao.getAllActive());
    }

    @Override
    public ResponseResult getAllActiveByPage(int pageNo) {
        PageHelper.startPage(pageNo,20);
        List<Active> all = activeDao.getAllActive();
        return ResponseResult.ok(all);
    }
}
