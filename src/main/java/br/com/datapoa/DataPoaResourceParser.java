package br.com.datapoa;

import java.net.MalformedURLException;
import java.net.URL;

public class DataPoaResourceParser {
	
	DataPoaResource dpResource;
	
	public DataPoaResourceParser(DataPoaResource dpResource)
	{
		this.dpResource = dpResource;
	}
	
	public URL toUrl() throws MalformedURLException
	{
		StringBuilder url = new StringBuilder(DataPoaUrls.DATA_SEARCH);
		url.append("resource_id="+dpResource.getResourceId());
		
		if(dpResource.getLimit()!=null)
			url.append("limit="+dpResource.getLimit());
		
		return new URL(url.toString());
	}

}
