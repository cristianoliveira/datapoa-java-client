package br.com.datapoa.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

import com.google.gson.JsonSyntaxException;

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
    
    private DataRequest dpRequest;
    private IDataRequestAsyncCallback<T> callback;
    private Class<T> typeOf;

    public DataRequestAsync(Class<T> typeOf, DataRequest dpRequest, IDataRequestAsyncCallback<T> callback) {
        this.dpRequest = dpRequest;
        this.typeOf = typeOf;
        this.callback = callback;
    }    
    
    @Override
    public void run() {
        try {
            
        	callback.postProgress("Requesting...");
        	DataResponse response;
        	try {
        		response  = dpRequest.request();
			} catch (IOException e) {
				throw new DataRequestException(e, DataRequestException.WHEN_REQUESTING_DATA);
			}
            
        	callback.postProgress("Parsing...");
        	T result;
        	try {
                result = new DataResponseParser(response).parseTo(typeOf);
			} catch (JsonSyntaxException e) {
				throw new DataRequestException(e, DataRequestException.WHEN_PARSING_DATA);
			}
            
        	callback.postProgress("Posting...");
        	try {
        		callback.postResult(result);
            } catch (Exception e) {
				throw new DataRequestException(e, DataRequestException.WHEN_POSTING_DATA);
			}
            
        	callback.onFinish();
        	
        } catch ( IOException e) {
            callback.postError(e);
        }
    }

}
