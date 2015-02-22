package br.com.datapoa;

import java.net.MalformedURLException;
import java.net.URL;

public class DataPoaResourceQueryBuilder {
	
	private DataPoaResource dpResource;
	
	public DataPoaResourceQueryBuilder build(String resourceId)
	{
		getResource().setResourceId(resourceId);
		return this;
	}
	
	public DataPoaResourceQueryBuilder limit(Integer limit)
	{
		getResource().setLimit(limit);
		return this;
	}
	
	public DataPoaResource build()
	{
		return dpResource;
	}
	
	public URL buildSearchUrl() throws MalformedURLException
	{
		return new DataPoaResourceParser(dpResource).toUrl();
	}
	
	private DataPoaResource getResource()
	{
		if(dpResource == null)
			dpResource = new DataPoaResource();
		return dpResource;
	}

}
