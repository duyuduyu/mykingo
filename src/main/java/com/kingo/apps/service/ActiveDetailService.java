package com.kingo.apps.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 激活服务层
 * @author Stephen Sun
 * @date 2017-02-10 10:54
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
public interface ActiveDetailService {

    /**
     *  分页查询
     * @param page
     * @param limit
     * @return
     */
    public JSONObject findByPage(int page, int limit);

    /**
     * 按日期查询
     * @param page 页码
     * @param limit 每页大小
     * @param sDate 开始日期
     * @param eDate 结束日期
     * @param chapp
     * @return
     */
    public JSONObject findByDate(int page, int limit, String sDate, String eDate, String chapp);

}
