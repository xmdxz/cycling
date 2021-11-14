package com.cycling.pojo.dto;

import com.cycling.pojo.Active;
import com.cycling.pojo.MapPojo;
import com.cycling.utils.MapUtil;
import lombok.Data;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2021/11/10 19:49
 */
@Data
public class ActiveWithMap {
    Active active;
    MapPojo map;

    public ActiveWithMap(Active active) {
        this.active = active;
        map = MapUtil.getMap(active.getMapId());
    }
}
