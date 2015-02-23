package br.com.datapoa;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

import br.com.datapoa.http.HttpClient;

public class DataPoaResourceParser {

    public static URL toUrl(DataPoaResource dpResource) throws MalformedURLException, UnsupportedEncodingException {

        if (dpResource == null || dpResource.getResourceId().isEmpty()) 
              throw new IllegalArgumentException( "DataPoaResource must be informed.");

        StringBuilder url = new StringBuilder(dpResource.getAction());
        url.append("resource_id=").append(dpResource.getResourceId());
        
        if (dpResource.getFilter() != null)
            url.append("&q=").append(URLDecoder.decode(dpResource.getFilter(), HttpClient.CHARSET));

        if (dpResource.getLimit() != null)
            url.append("&limit=").append(dpResource.getLimit());

        return new URL(url.toString());
    }

}
