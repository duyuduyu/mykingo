package com.kingo.apps.controller;

import com.alibaba.fastjson.JSONObject;
import com.kingo.apps.service.ActiveDetailService;
import com.kingo.apps.util.ExceptionUtil;
import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 激活详情
 * @author Stephen Sun
 * @date 2017-02-10 10:24
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
@RequestMapping("active")
public class ActiveDetailController {



    @Autowired
    ActiveDetailService activeDetailService;

    @RequestMapping("detail")
    public ModelAndView go(){
        return new ModelAndView("active/detail");
    }


    @RequestMapping("findPage")
    @ResponseBody
    public JSONObject findByPage(@Param Integer offset, @Param Integer limit){
        JSONObject jsonObject = null;
        try {
            if(StringUtils.isEmpty(offset) || StringUtils.isEmpty(limit)){
                offset = 1;
                limit = 20;
            }
            jsonObject = activeDetailService.findByPage(offset, limit);
        }catch (Exception e){
            ExceptionUtil.getCatch(e);
        }
        return jsonObject;
    }


    @RequestMapping("findDate")
    @ResponseBody
    public JSONObject findByDate(@Param Integer offset, @Param Integer limit, @Param String sDate, @Param String eDate, @Param String chapp){
        JSONObject jsonObject = null;
        try {
            if(StringUtils.isEmpty(offset) || StringUtils.isEmpty(limit)){
                offset = 1;
                limit = 20;
            }
            jsonObject = activeDetailService.findByDate(offset, limit, sDate, eDate, chapp);
        }catch (Exception e){
            ExceptionUtil.getCatch(e);
        }
        return jsonObject;
    }

}
