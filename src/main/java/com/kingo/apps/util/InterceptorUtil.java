package com.kingo.apps.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Stephen Sun
 * @date 2017-02-13 19:21
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━感觉萌萌哒━━━━━━
 */
public class InterceptorUtil extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        Subject subject;
        /** 权限  也是 请求的 url */
        String per = req.getRequestURI();

        if(per.contains("assets")){
            return super.preHandle(req, resp, handler);
        }
        try {
            subject = SecurityUtils.getSubject();
            boolean roles = subject.isPermitted(per);
            if (!roles && subject != null && !"/mykingo/index/nop".equals(per)) {
                resp.sendRedirect("/mykingo/index/nop");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return super.preHandle(req, resp, handler);
    }


}
