package com.cycling.service.impl;

import com.cycling.dao.ActiveDao;
import com.cycling.dao.UserDao;
import com.cycling.pojo.Active;
import com.cycling.pojo.dto.ActiveWithMap;
import com.cycling.service.ActiveService;
import com.cycling.utils.MapUtil;
import com.cycling.utils.ResponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.javassist.bytecode.Descriptor;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/10/28 20:27
 */
@Log4j2
@Service
public class ActiveServiceImpl implements ActiveService {
    @Resource
    private ActiveDao activeDao;
    @Resource
    private UserDao userDao;

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
    public ResponseResult getAllActiveByPage(Long id) {

        //PageHelper.startPage(pageNo,20);
        if (id == null) id =5L;
        List<Active> all = activeDao.getAllAvtiveBypage(id);
        List<ActiveWithMap> allwithmao = new ArrayList<>();
        try {
            //每次往后取20个
            for (Active a: all) {
                ActiveWithMap aw =MapUtil.getMapActive(a);
                aw.setUserShow(userDao.getUserShowInfo(a.getAuthorid()));        //预留
                //log.error(userDao.getUserShowInfo(a.getAuthorid()));
                allwithmao.add(aw);
            }
        }catch (DocumentException e){
            log.error("读取地图失败");
            log.error(e);
        }
        return ResponseResult.ok(allwithmao);
    }

    @Override
    public ResponseResult getActiveByAreaAndPage(String area, Long id) {
        return null;
    }

    @Override
    public ResponseResult getActiveByKeywords(String keywords) {
        return null;
    }

    @Override
    public ResponseResult getActiveByTags(List<String> tags) {
        return null;
    }

    @Override
    public ResponseResult getActive(long id) throws DocumentException {
        Active a= activeDao.getActive(id);
        ActiveWithMap aw =MapUtil.getMapActive(a);
        aw.setUserShow(userDao.getUserShowInfo(a.getAuthorid()));
        return ResponseResult.ok(aw);
    }
}
