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
     * Execute a request with resource parameters
     * 
     * @return DataResponse Data from webservice
     * @throws DataRequestException when HttpClient does't has response
     */
    public DataResponse request() throws DataRequestException {

        HttpParameterSet parameters = getParameterSet();

        HttpResponse httpResponse = getResponseFrom(parameters);

        return dataResponseFrom(httpResponse);
    }

    private HttpParameterSet getParameterSet() throws DataRequestException {
        HttpParameterSet parameters;
        try {
            parameters = DataResourceParser.toHttpParameterSet(dpResource);
        } catch (IOException e) {
            throw new DataRequestException(e, DataRequestException.WHEN_PARSING_RESOURCE);
        }
        return parameters;
    }

    private DataResponse dataResponseFrom(HttpResponse httpResponse) throws DataRequestException {
        DataResponse dataResponse;
        try {
            dataResponse = DataResponseFactory.createFrom(httpResponse);
        } catch (IOException e) {
            throw new DataRequestException(e, DataRequestException.WHEN_PARSING_DATA);
        }
        return dataResponse;
    }

    private HttpResponse getResponseFrom(HttpParameterSet parameters) throws DataRequestException {
        HttpResponse httpResponse;
        try {
            httpResponse =
                    getHttpClient().request(HttpMethod.GET, dpResource.getAction(), parameters);
        } catch (IOException e) {
            throw new DataRequestException(e, DataRequestException.WHEN_REQUESTING_DATA);
        }

        return httpResponse;
    }

    private HttpClient getHttpClient() {
        return new HttpClient();
    }

}
