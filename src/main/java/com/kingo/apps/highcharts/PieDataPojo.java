package com.kingo.apps.highcharts;

/**
 * 饼图 环图 series
 * 
 * @author sunshipeng
 * @date 2016-5-3
 *
 */
public class PieDataPojo {

	private String name;

	private Double y;

	private Boolean sliced = false;

	private Boolean selected = false;

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Boolean getSliced() {
		return sliced;
	}

	public void setSliced(Boolean sliced) {
		this.sliced = sliced;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
