package com.cycling.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: R
 * @Author: RainGoal
 * @Description: TODO
 * @Date: 2021/9/29 12:26 下午
 */

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R(String msg, int code) {
        put("msg", msg);
        put("code", code);
    }

    public static R ok() {
        return new R("success", 200);
    }

    public static R ok(Map<String, Object> map) {
        R ok = ok();
        ok.put("data", map);
        return ok;
    }

    public static <T> R ok(T data){
        R ok = ok();
        ok.put("data",data);
        return ok;
    }

    public static R error(String msg) {
        return new R(msg, 500);
    }

    public static R error(String msg,int code){
        return new R(msg,code);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
