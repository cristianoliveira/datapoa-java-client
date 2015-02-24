package br.com.datapoa.request;

import java.io.IOException;
import java.net.URL;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpResponse;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceParser;
import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseFactory;

public class DataRequest {

    private DataResource dpResource;

    public DataRequest(DataResource dpResource) {
        this.dpResource = dpResource;
    }

    /**
     * 
     *  Execute a request with resource parameters
     * 
     * @return DataResponse Data from webservice
     * @throws IOException when HttpClient does't has response
     */
    public DataResponse request() throws IOException {
        
        HttpParameterSet parameters = DataResourceParser.toHttpParameterSet(dpResource);
        HttpResponse httpResponse = new HttpClient().request(HttpMethod.GET, dpResource.getAction(), parameters);

        DataResponse dataResponse = DataResponseFactory.createFrom(httpResponse);
        
        return dataResponse;
    }
    
}
