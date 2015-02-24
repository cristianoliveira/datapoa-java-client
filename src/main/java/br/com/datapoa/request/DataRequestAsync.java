package br.com.datapoa.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpResponse;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceParser;
import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseFactory;
import br.com.datapoa.response.DataResponseParser;

public final class DataRequestAsync<T> implements Runnable {
    
    private DataResource dpResource;
    private IDataRequestAsyncCallback<T> callback;
    private Class<T> typeOf;

    public DataRequestAsync(Class<T> typeOf, DataResource dpResource, IDataRequestAsyncCallback<T> callback) {
        this.dpResource = dpResource;
        this.typeOf = typeOf;
        this.callback = callback;
    }    
    
    @Override
    public void run() {
        
        HttpParameterSet parameters;
        try {
            parameters = DataResourceParser.toHttpParameterSet(dpResource);
        
            callback.postProgress("Requesting...");
            
            HttpResponse httpResponse = new HttpClient().request(HttpMethod.GET, dpResource.getAction(), parameters);

            DataResponse dataResponse = DataResponseFactory.createFrom(httpResponse);
            
            callback.postProgress("Casting results...");
            
            T response = new DataResponseParser(dataResponse).parseTo(typeOf);
            
            callback.postResult(response);
            callback.onFinish();
            
        } catch ( IOException e) {
            callback.postError(e);
        }
    }

}
