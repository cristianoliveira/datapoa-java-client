package br.com.datapoa;

public class DataPoaResponse {
	
	private String jsonString;
	
	/**
	 * 
	 *  This object hold result of request to be parse.
	 *  It can't be called out of package
	 *  
	 */
	DataPoaResponse()
	{
	}
	
	public void setJsonString(String json) {
		this.jsonString = json;
	}
	
	public String getJsonString()
	{
		return this.jsonString;
	}
}
