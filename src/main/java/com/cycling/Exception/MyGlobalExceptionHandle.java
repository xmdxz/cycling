package com.cycling.Exception;

import com.cycling.utils.ResponseResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName: MyGlobalExceptionHandle
 * @Description: 在该类中，可以定义多个方法，不同的方法处理不同的异常
 * @Author: qyz
 * @date: 2021/10/28 15:23
 * @Version: V1.0
 */

@ControllerAdvice//处理全局异常
@ResponseBody
public class MyGlobalExceptionHandle {


    /*
       捕捉所有的shiro异常  全部shiro的异常
     */
    @ExceptionHandler(ShiroException.class)
    public ResponseResult handleShiroException(ShiroException e){

        return ResponseResult.error("无权访问:" + e.getMessage(),401);

    }

    /*
       捕捉没有该有的权限抛出的shiro异常  没有授权的异常
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseResult handleUnauthorizedException(UnauthorizedException e)
    {
        return ResponseResult.error("无权访问:当前用户没有此请求所需权限("+e.getMessage()+")",401);
    }


    /*
      捕捉以游客访问时无权访问的异常 没有认证登录异常
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult handle401(UnauthenticatedException e) {
        return ResponseResult.error( "无权访问:当前用户没有登录，请先登录"+e.getMessage(),401);
    }


    /*
     * 捕捉404异常  没有发现页面的异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseResult handle(NoHandlerFoundException e) {
        return ResponseResult.error(e.getMessage(),404);
    }

    /*
     * 捕捉其他所有异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult globalException(HttpServletRequest request, Throwable ex) {
        return ResponseResult.error(ex.toString() + ": " + ex.getMessage());
    }
}
