package com.kingo.apps.controller;

import com.alibaba.fastjson.JSONObject;
import com.kingo.apps.highcharts.HchartPojo;
import com.kingo.apps.service.ActiveCountService;
import com.kingo.apps.util.DateUtil;
import com.kingo.apps.util.ExceptionUtil;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Stephen Sun
 * @date 2017-02-10 17:33
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
@Controller
@RequestMapping("activeCount")
public class ActiveCountController {



    @Autowired
    ActiveCountService activeCountService;


    @RequestMapping("ccount")
    public ModelAndView go(){
        return new ModelAndView("active/count");
    }


    @RequestMapping("findByChart")
    @ResponseBody
    public JSONObject findByChart(@Param String start, @Param String end, @Param String chapp){
        JSONObject jsonObject = new JSONObject();
        try {
            if(StringUtils.isEmpty(start) || StringUtils.isEmpty(end)){
                // 如果日期为空，获取默认一周前的日期间隔
                start = DateUtil.getDateByDay(-6);
                end = DateUtil.getDateByDay(1);
            }
            if(StringUtils.isEmpty(chapp)){
                chapp = "all";
            }
            HchartPojo hchartPojo = activeCountService.findByChart(start, end, chapp);
            jsonObject.put("charts", hchartPojo);
            jsonObject.put("status", 1);
        }catch (Exception e){
            ExceptionUtil.getCatch(jsonObject, e);
        }
        return jsonObject;
    }


}
