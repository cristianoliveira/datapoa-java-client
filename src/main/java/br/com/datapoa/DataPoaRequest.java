package br.com.datapoa;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpResponse;

public class DataPoaRequest {

    private DataPoaResource dpResource;

    public DataPoaRequest(DataPoaResource dpResource) {
        this.dpResource = dpResource;
    }

    public DataPoaResponse request() throws IOException {
        HttpClient httpCliente = new HttpClient();
        URL resourceURL = DataPoaResourceParser.toUrl(dpResource);
        HttpResponse httpResponse = httpCliente.request(HttpMethod.GET, resourceURL);

        return new DataPoaResponseFactory().createFrom(httpResponse);
    }

}
