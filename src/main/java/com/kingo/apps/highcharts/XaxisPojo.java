package com.kingo.apps.highcharts;

/**
 * X轴坐标
 * 
 * @author sunshipeng
 * @date 2016-4-27
 */
public class XaxisPojo {

	
	/**
	 * 
	 * 类别名称。从Highcharts3.0以后，通过获取数据列中数据的name和设置坐标轴的type为"category"可以初步制作出类别轴。
	 * 例如：
	 * categories: ['Apples', 'Bananas', 'Oranges']
	 */
	private Object categories;

	/**
	 * 坐标轴上的刻度线的单位间隔。当值为null时，刻度线间隔是根据近似于线性的(tickPixelInterval)计算的。在分类轴上，
	 * 一个null的刻度间隔，默认为1，即1个类目。要注意的是，时间轴是根据毫秒来计算的，例如一天的间隔表示为24 * 3600 * 1000。
	 * 在对数轴上，刻度线间隔按指数幂来算，刻度线间隔为1时，在刻度上的每个值为0.1, 1, 10, 100等。
	 * 刻度间隔为2时，在刻度上的每个值为0.1, 10, 1000等。 刻度间隔为0.2时，在刻度上的值为: 0.1, 0.2, 0.4, 0.6,
	 * 0.8, 1, 2, 4, 6, 8, 10, 20, 40等
	 */
	private Integer tickInterval = 1;

	public Object getCategories() {
		return categories;
	}

	public void setCategories(Object categories) {
		this.categories = categories;
	}

	public Integer getTickInterval() {
		return tickInterval;
	}

	public void setTickInterval(Integer tickInterval) {
		this.tickInterval = tickInterval;
	}
	
	

}
