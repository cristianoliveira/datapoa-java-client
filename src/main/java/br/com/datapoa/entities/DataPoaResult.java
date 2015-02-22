package br.com.datapoa.entities;

import java.util.List;
import java.util.Map;

public class DataPoaResult {

    private String resource_id;
    private List<DataPoaField> fields;
    private Map<String, String> results;
    private Map<String, String> _links;
    private Integer limit;
    private Integer total;

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public List<DataPoaField> getFields() {
        return fields;
    }

    public void setFields(List<DataPoaField> fields) {
        this.fields = fields;
    }

    public Map<String, String> getResults() {
        return results;
    }

    public void setResults(Map<String, String> results) {
        this.results = results;
    }

    public Map<String, String> get_links() {
        return _links;
    }

    public void set_links(Map<String, String> _links) {
        this._links = _links;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

}
