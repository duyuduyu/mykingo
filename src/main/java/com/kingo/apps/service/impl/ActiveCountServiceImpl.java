package com.kingo.apps.service.impl;

import com.kingo.apps.entity.Active;
import com.kingo.apps.highcharts.HchartPojo;
import com.kingo.apps.repository.ActiveMapper;
import com.kingo.apps.service.ActiveCountService;
import com.kingo.apps.util.HchartUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen Sun
 * @date 2017-02-10 16:55
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
public class ActiveCountServiceImpl implements ActiveCountService {


    @Autowired
    ActiveMapper activeMapper;


    @Override
    public HchartPojo findByChart(String start, String end, String chapp) {
        List<Map<String, Object>> list;
        if("all".equals(chapp)){
            list = activeMapper.finfByChart(start, end);
        }else{
            list = activeMapper.finfByChartChapp(start, end, chapp);
        }
        HchartPojo hchartPojo = HchartUtil.parseSingleHchart(list, true, "每天激活收入曲线");
        return hchartPojo;
    }

}
