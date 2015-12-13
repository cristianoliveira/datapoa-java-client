package br.com.datapoa.resources;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpParameterSetParser;

public class DataResourceParser {

    /**
     * 
     * Create HttpParameterSet from a resource
     * 
     * @param dpResource DataResource Resource to be parsed
     * @return HttpParameterSet Parameters to execute a HttpRequest
     * @throws IllegalArgumentException when resource is null
     * @throws MalformedURLException when resource has wrong values
     * @throws UnsupportedEncodingException when resource has wrong values
     */
    public static HttpParameterSet toHttpParameterSet(DataResource dpResource)
            throws MalformedURLException, UnsupportedEncodingException {

        if (dpResource == null)
            throw new IllegalArgumentException("DataPoaResource must be informed.");

        DataResourceParameterSetBuilder dataUrlBuilder = new DataResourceParameterSetBuilder();

        if (dpResource.getResourceId() != null) {
            dataUrlBuilder.withResourceId(dpResource.getResourceId());
        }

        if (dpResource.getFilter() != null) {
            dataUrlBuilder.withFilter(dpResource.getFilter());
        }

        if (dpResource.getLimit() != null) {
            dataUrlBuilder.withLimit(dpResource.getLimit());
        }

        return dataUrlBuilder.build();
    }

}
