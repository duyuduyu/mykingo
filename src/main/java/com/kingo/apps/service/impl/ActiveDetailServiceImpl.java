package com.kingo.apps.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kingo.apps.entity.Active;
import com.kingo.apps.repository.ActiveMapper;
import com.kingo.apps.service.ActiveDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Stephen Sun
 * @date 2017-02-10 11:02
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
@Service
public class ActiveDetailServiceImpl implements ActiveDetailService {



    @Autowired
    ActiveMapper activeMapper;


    @Override
    public JSONObject findByPage(int page, int limit) {
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(page, limit); // 核心分页代码
        List<Active> bList = activeMapper.findAll();
        PageInfo pageInfo = new PageInfo(bList);
        long l = pageInfo.getTotal();
        jsonObject.put("total", l);
        jsonObject.put("rows", bList);
        return jsonObject;
    }


    @Override
    public JSONObject findByDate(int page, int limit, String sDate, String eDate, String chapp) {
        JSONObject jsonObject = new JSONObject();
        PageHelper.startPage(page, limit); // 核心分页代码
        List<Active> bList;
        if("all".equals(chapp) && (StringUtils.isEmpty(sDate) || StringUtils.isEmpty(eDate))){
            bList = activeMapper.findAll();
        }else if("all".equals(chapp) && !(StringUtils.isEmpty(sDate) || StringUtils.isEmpty(eDate))){
            bList = activeMapper.findByDate(sDate, eDate);
        }else if(!("all".equals(chapp)) && (StringUtils.isEmpty(sDate) || StringUtils.isEmpty(eDate))){
            bList = activeMapper.findByChapp(chapp);
        }else{
            bList = activeMapper.findByDateAndChapp(sDate, eDate, chapp);
        }
        PageInfo pageInfo = new PageInfo(bList);
        long l = pageInfo.getTotal();
        jsonObject.put("total", l);
        jsonObject.put("rows", bList);
        return jsonObject;
    }
}
