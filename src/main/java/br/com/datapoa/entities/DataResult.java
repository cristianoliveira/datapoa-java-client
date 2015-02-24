package br.com.datapoa.entities;

import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class DataResult {

	@SerializedName("resource_id")
    private String resourceId;
    private List<DataField> fields;
    private List<JsonObject> records;
    @SerializedName("_links")
    private JsonObject links;
    private Integer limit;
    private Integer total;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<DataField> getFields() {
        return fields;
    }

    public void setFields(List<DataField> fields) {
        this.fields = fields;
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

	public List<JsonObject> getRecords() {
	    return records;
    }

	public void setRecords(List<JsonObject> records) {
	    this.records = records;
    }

	public JsonObject getLinks() {
	    return links;
    }

	public void setLinks(JsonObject links) {
	    this.links = links;
    }

}
