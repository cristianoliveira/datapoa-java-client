package br.com.datapoa.resources;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import br.com.datapoa.http.HttpClient;

public class DataResourceUrlBuilder {
    
    private StringBuilder urlBuilder;
    private final String PARAMETER_NAME_RESOURCE = "resource_id";
    private final String PARAMETER_NAME_FILTER = "q";
    private final String PARAMETER_NAME_LIMIT = "limit";
    
    public DataResourceUrlBuilder(String action, String resourceId)
    {
        getStringBuilder().append(action).append("?").append(PARAMETER_NAME_RESOURCE).append("=").append(resourceId);
    }
    
    public DataResourceUrlBuilder withLimit(Integer limit) throws UnsupportedEncodingException
    {
        add(PARAMETER_NAME_LIMIT, limit.toString());
        return this;
    }
    
    public DataResourceUrlBuilder withFilter(String filter) throws UnsupportedEncodingException
    {
        add(PARAMETER_NAME_FILTER, filter);
        return this;
    }
    
    public URL build() throws MalformedURLException
    {
        return new URL(getStringBuilder().toString());
    }
    
    private void add(String name, String value) throws UnsupportedEncodingException
    {
        String encoded = URLEncoder.encode(value, HttpClient.CHARSET);
        getStringBuilder().append("&").append(name).append("=").append(encoded);
    }
    
    private StringBuilder getStringBuilder()
    {
        if(this.urlBuilder == null)
        {
            this.urlBuilder = new StringBuilder();
        }
        return urlBuilder;
    }

}
