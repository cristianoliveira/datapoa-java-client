package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.request.DataRequest;
import br.com.datapoa.request.DataRequestAsync;
import br.com.datapoa.request.DataRequestException;
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
    public DataEntity doRequest() throws DataRequestException {
        
    	return resultAs(DataEntity.class);
    }

    /**
     * 
     *  Request data from resource and return Customized Class
     * 
     * @param Class<T> Class extended from Entity.class to format and receive data
     * @return Class<T> formated data based on a Customized class
     * @throws IOException
     */
    public <T> T doRequest(Class<T> clas) throws DataRequestException {
        return resultAs(clas);
    }
    
    /**
     *  
     *  Request data from resource in an Asynchronous way. It need a callback.
     *  
     * @param typeOf Type of Entity that will return in callback
     * @param callback Implement of IDataRequestAsyncCallback to retrieve results. If it raise a error this exception will be hold on callback
     */
    public <T> void doAsyncRequest(Class<T> typeOf, IDataRequestAsyncCallback<T> callback) {
        DataRequestAsync<T> dataRequest = new DataRequestAsync<T>(typeOf, getRequest(), callback);
        new Thread(dataRequest).start();
    }
    
    private <T> T resultAs(Class<T> clas) throws DataRequestException
    {
    	return new DataResponseParser(getResponse()).parseTo(clas);
    }
    
    private DataResponse getResponse() throws DataRequestException
    {
        return getRequest().request();
    }
    
    private DataRequest getRequest()
    {
    	return new DataRequest(dpResource);
    }

}
