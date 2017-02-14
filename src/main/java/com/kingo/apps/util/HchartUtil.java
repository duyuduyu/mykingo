package com.kingo.apps.util;

import com.kingo.apps.highcharts.HchartPojo;
import com.kingo.apps.highcharts.SeriesPojo;
import com.kingo.apps.highcharts.XaxisPojo;

import java.util.List;
import java.util.Map;

/**
 * @author Stephen Sun
 * @date 2017-02-10 17:21
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
public class HchartUtil {



    /**
     * 单挑曲线
     * @param list
     * @param visible 是否可见
     * @return
     */
    public static HchartPojo parseSingleHchart(List<Map<String, Object>> list, boolean visible, String lineName){
        HchartPojo hchartPojo = new HchartPojo();
        XaxisPojo xaxisPojo = new XaxisPojo();
        SeriesPojo seriesPojo = new SeriesPojo();
        int size = list.size();
        Object[] x = new String[size];
        double[] y = new double[size];

        for(int i=0; i<size; i++){
            Map<String, Object> map = list.get(i);
            x[i] = map.get("cdate").toString();
            y[i] = Double.parseDouble(map.get("ccount").toString());
        }
        xaxisPojo.setCategories(x);
        seriesPojo.setData(y);
        seriesPojo.setVisible(visible);
        seriesPojo.setName(lineName);

        hchartPojo.setXaxisPojo(xaxisPojo);
        hchartPojo.setSeriesPojo(new SeriesPojo[]{seriesPojo});
        return hchartPojo;
    }


}
