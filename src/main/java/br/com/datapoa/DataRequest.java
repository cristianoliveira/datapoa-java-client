package br.com.datapoa;

import java.io.IOException;
import java.net.URL;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpResponse;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceParser;
import br.com.datapoa.response.DataPoaResponse;
import br.com.datapoa.response.DataPoaResponseFactory;

public class DataRequest {

    private DataResource dpResource;

    public DataRequest(DataResource dpResource) {
        this.dpResource = dpResource;
    }

    public DataPoaResponse request() throws IOException {
        
        HttpClient httpCliente = new HttpClient();
        URL resourceURL = DataResourceParser.toUrl(dpResource);
        HttpResponse httpResponse = httpCliente.request(HttpMethod.GET, resourceURL);

        return new DataPoaResponseFactory().createFrom(httpResponse);
    }

}
