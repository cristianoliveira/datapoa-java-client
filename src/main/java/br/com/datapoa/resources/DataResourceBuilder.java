package br.com.datapoa.resources;

public class DataResourceBuilder {

    private DataResource dpResource;

    public DataResourceBuilder action(String action) {
        getResource().setAction(action);
        return this;
    }

    public DataResourceBuilder resource(String resourceId) {
        getResource().setResourceId(resourceId);
        return this;
    }

    public DataResourceBuilder limit(Integer limit) {
        getResource().setLimit(limit);
        return this;
    }

    public DataResourceBuilder filter(String filter) {
        dpResource.setFilter(filter);
        return this;
    }
    
    public DataResource build() {
        return dpResource;
    }

    private DataResource getResource() {
        if (dpResource == null)
            dpResource = new DataResource();
        return dpResource;
    }

}
