package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.request.DataRequest;
import br.com.datapoa.request.DataRequestAsync;
import br.com.datapoa.request.IDataRequestAsyncCallback;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseParser;

public class DataClient {

    private DataResource dpResource;

    /**
     * 
     *  Create a data client with resource.
     * 
     * @param DataResource resource to be requested data 
     */
    public DataClient(DataResource dpResource) {
        this.dpResource = dpResource;
    }
    
    /**
     * 
     *  Request data from resource
     * 
     * @return DataEntity whit response from resource
     * @throws IOException when HttpClient doesn't response 
     */
    public DataEntity doRequest() throws IOException {
        
    	DataResponse dpResponse = getResponse();
        
        return new DataResponseParser(dpResponse).parseTo(DataEntity.class);
    }

    /**
     * 
     *  Request data from resource and return Customized Class
     * 
     * @param Class<T> Class extended from Entity.class to format and receive data
     * @return Class<T> formated data based on a Customized class
     * @throws IOException
     */
    public <T> T doRequest(Class<T> clas) throws IOException {
        
    	DataResponse dpResponse = getResponse();
    	
        return new DataResponseParser(dpResponse).parseTo(clas);
    }
    
    /**
     *  
     *  Request data from resource in an Asynchronous way. It need a callback.
     *  
     * @param typeOf Type of Entity that will return in callback
     * @param callback Implement of IDataRequestAsyncCallback to retrieve results. If it raise a error this exception will be hold on callback
     */
    public <T> void doAsyncRequest(Class<T> typeOf, IDataRequestAsyncCallback<T> callback) {
        
        new Thread(new DataRequestAsync<T>(typeOf, dpResource, callback)).start();
    }
    
    private DataResponse getResponse() throws IOException
    {
        return new DataRequest(dpResource).request();
    }

}
