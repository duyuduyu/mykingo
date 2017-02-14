package com.kingo.apps.highcharts;

import java.util.List;

/**
 * 图表模型
 * @author Stephen Sun
 * @date 2016/10/25 10:01
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
public class HchartPojo {

    private SeriesPojo[] seriesPojo;

    private AddSeriesPojo addSeriesPojo;

    private XaxisPojo xaxisPojo;

    private TotalPiePojo totalPiePojo;

    private List<ColumnPojo> columnPojoSeries;

    public SeriesPojo[] getSeriesPojo() {
        return seriesPojo;
    }

    public void setSeriesPojo(SeriesPojo[] seriesPojo) {
        this.seriesPojo = seriesPojo;
    }

    public AddSeriesPojo getAddSeriesPojo() {
        return addSeriesPojo;
    }

    public void setAddSeriesPojo(AddSeriesPojo addSeriesPojo) {
        this.addSeriesPojo = addSeriesPojo;
    }

    public XaxisPojo getXaxisPojo() {
        return xaxisPojo;
    }

    public void setXaxisPojo(XaxisPojo xaxisPojo) {
        this.xaxisPojo = xaxisPojo;
    }

    public TotalPiePojo getTotalPiePojo() {
        return totalPiePojo;
    }

    public void setTotalPiePojo(TotalPiePojo totalPiePojo) {
        this.totalPiePojo = totalPiePojo;
    }

    public List<ColumnPojo> getColumnPojoSeries() {
        return columnPojoSeries;
    }

    public void setColumnPojoSeries(List<ColumnPojo> columnPojoSeries) {
        this.columnPojoSeries = columnPojoSeries;
    }
}
