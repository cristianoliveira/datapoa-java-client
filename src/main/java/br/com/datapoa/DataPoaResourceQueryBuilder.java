package br.com.datapoa;

public class DataPoaResourceQueryBuilder {
	
	private DataPoaResource dpResource;
	
	public DataPoaResourceQueryBuilder action(String action)
	{
		getResource().setAction(action);
		return this;
	}
	
	public DataPoaResourceQueryBuilder resource(String resourceId)
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
	
	private DataPoaResource getResource()
	{
		if(dpResource == null)
			dpResource = new DataPoaResource();
		return dpResource;
	}

}
