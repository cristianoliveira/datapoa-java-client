package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.response.DataPoaResponse;
import br.com.datapoa.response.DataPoaResponseParser;

public class DataClient {

    private DataResource dpResource;

    /**
     * 
     *  Create a data client with resource.
     * 
     * @param DataResource dpResource 
     */
    public DataClient(DataResource dpResource) {
        this.dpResource = dpResource;
    }
    
    /**
     * 
     *  Request data from resource
     * 
     * @return DataEntity 
     * @throws IOException
     */
    public DataEntity doRequest() throws IOException {
        
    	DataPoaResponse dpResponse = getResponse();
        
        return new DataPoaResponseParser(dpResponse).parseTo(DataEntity.class);
    }

    /**
     * 
     *  Request data from resource and return Customized Class
     * 
     * @param Class<T> clas  Class extendend from Entity.class to receive data
     * @return Class<T> Data formated at new class
     * @throws IOException
     */
    public <T> T doRequest(Class<T> clas) throws IOException {
        
    	DataPoaResponse dpResponse = getResponse();
    	
        return new DataPoaResponseParser(dpResponse).parseTo(clas);
    }
    
    private DataPoaResponse getResponse() throws IOException
    {
        return new DataRequest(dpResource).request();
    }

}
