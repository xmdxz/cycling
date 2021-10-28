package com.cycling.utils;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;


/**
 * @Author xpdxz
 * @ClassName RequestUtil
 * @Description TODO
 * @Date 2021/10/28 11:47
 */
public class RequestUtil {
    /**
     * 获取当前request的值
     * @param parameter 参数
     * @return value
     */
    public static String getRequestValue(String parameter){
        final RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        if (parameter == null || ObjectUtils.isEmpty(attributes)){
            return null;
        }
        return (String) attributes.getAttribute(parameter, RequestAttributes.SCOPE_REQUEST);
    }

}
