package br.com.datapoa.resources;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import br.com.datapoa.http.HttpClient;

public class DataResourceParser {

    public static URL toUrl(DataResource dpResource) throws MalformedURLException, UnsupportedEncodingException {

        if (dpResource == null || dpResource.getResourceId().isEmpty()) 
              throw new IllegalArgumentException( "DataPoaResource must be informed.");

        DataResourceUrlBuilder dataUrlBuilder = new DataResourceUrlBuilder(dpResource.getAction(), dpResource.getResourceId());
        
        if (dpResource.getFilter() != null)
            dataUrlBuilder.withFilter(dpResource.getFilter());

        if (dpResource.getLimit() != null)
            dataUrlBuilder.withLimit(dpResource.getLimit());

        return dataUrlBuilder.build();
    }

}
