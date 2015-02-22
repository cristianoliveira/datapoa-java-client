package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.http.HttpResponse;

public class DataPoaResponseFactory {
	
	public DataPoaResponse createFrom(HttpResponse httpRespose) throws IOException
	{
		if(httpRespose == null)
			return null;
		
		DataPoaResponse response = new DataPoaResponse();
		response.setJsonString(httpRespose.asString());
		
		return response;
	}

}
