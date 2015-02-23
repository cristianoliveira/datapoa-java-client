package br.com.datapoa;

class DataPoaResource {

    private IDataProvider provider;
	
	private String action;
    private String resourceId;
    private Integer limit;
    private String filter;
    
    DataPoaResource()
    {
    	this.provider = DataPoaCommon.getProvider();
    }
    
    public void setProvider(IDataProvider provider)
    {
        this.provider = provider;
    }

    public String getAction() {
        if (action == null)
            return provider.getDataSearchUrl();
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

}
