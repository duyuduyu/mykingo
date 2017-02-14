package com.kingo.apps.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * 异常工具类
 * @author Stephen Sun
 * @date 2017-02-10 14:57
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
public class ExceptionUtil {


    private static final Logger logger = Logger.getLogger(ExceptionUtil.class);

    /**
     * 获取异常并发送邮件,new JSONObject
     * @param e
     */
    public static void getCatch(Exception e){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 0);
        jsonObject.put("msg", "系统异常");
        logger.error("kingo后台error:", e);
        e.printStackTrace();
    }


    /**
     * 获取异常并发送邮件,不需要new JSONObject
     * @param e
     */
    public static void getCatch(JSONObject jsonObject, Exception e){
        jsonObject.put("status", 0);
        jsonObject.put("msg", "系统异常");
        logger.error("kingo后台error:", e);
        e.printStackTrace();
    }

    /**
     * 执行成功返回 status = 1
     */
    public static void getSuccess(JSONObject jsonObject){
        jsonObject.put("status", 1);
        jsonObject.put("msg", "success");
    }

}
