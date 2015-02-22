package br.com.datapoa;

import com.google.gson.GsonBuilder;

public class DataPoaResponseParser {

	private DataPoaResponse dpResponse;
	
	public DataPoaResponseParser(DataPoaResponse dpResponse)
	{
		this.dpResponse = dpResponse;
	}
	
	public <T> T parseTo(Class<T> clas)
	{
		return new GsonBuilder().create().fromJson(dpResponse.getJsonString(), clas);
	}
}
