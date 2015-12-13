package br.com.datapoa.resources;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpParameter;
import br.com.datapoa.http.HttpParameterSet;

public class DataResourceParameterSetBuilder {

    private HttpParameterSet paramerBuilder;
    private final String PARAMETER_NAME_RESOURCE = "resource_id";
    private final String PARAMETER_NAME_FILTER = "q";
    private final String PARAMETER_NAME_LIMIT = "limit";

    public DataResourceParameterSetBuilder withResourceId(String resourceId) {
        getHttpParameterSet().add(
                new HttpParameter(PARAMETER_NAME_RESOURCE, resourceId));
        return this;
    }

    public DataResourceParameterSetBuilder withLimit(Integer limit)
            throws UnsupportedEncodingException {
        add(PARAMETER_NAME_LIMIT, limit.toString());
        return this;
    }

    public DataResourceParameterSetBuilder withFilter(String filter)
            throws UnsupportedEncodingException {
        add(PARAMETER_NAME_FILTER, filter);
        return this;
    }

    public HttpParameterSet build() throws MalformedURLException {
        return paramerBuilder;
    }

    private void add(String name, String value)
            throws UnsupportedEncodingException {
        this.paramerBuilder.add(new HttpParameter(name, value));
    }

    private HttpParameterSet getHttpParameterSet() {
        if (this.paramerBuilder == null) {
            this.paramerBuilder = new HttpParameterSet();
        }
        return paramerBuilder;
    }

}
