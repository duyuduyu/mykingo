package com.kingo.apps.highcharts;

public class SeriesPojo {

	/**
	 * the name of the series as shown in the legend,
	 */
	private String name;

	/**
	 * 轴线的宽度
	 */
	private Integer lineWidth = 2;

	private Boolean visible = true;

	private Object data;

	private String stack;

	public Integer getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

}
