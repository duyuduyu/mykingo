package com.kingo.apps.highcharts;

import java.util.List;

public class TotalPiePojo {

	private List<PieDataPojo> edtionDatas;

	private List<PieDataPojo> channelDatas;

	private String editionName = "Top版本";

	private String channelName  = "Top渠道";

	public List<PieDataPojo> getEdtionDatas() {
		return edtionDatas;
	}

	public void setEdtionDatas(List<PieDataPojo> edtionDatas) {
		this.edtionDatas = edtionDatas;
	}

	public List<PieDataPojo> getChannelDatas() {
		return channelDatas;
	}

	public void setChannelDatas(List<PieDataPojo> channelDatas) {
		this.channelDatas = channelDatas;
	}

	public String getEditionName() {
		return editionName;
	}

	public void setEditionName(String editionName) {
		this.editionName = editionName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

}
