package br.com.datapoa;

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
     * Create a data client with resource.
     * 
     * @param dpResource
     *            DataResource resource to be requested data
     */
    public DataClient(DataResource dpResource) {
        this.dpResource = dpResource;
    }

    /**
     * 
     * Request data from resource
     * 
     * @return DataEntity whit response from resource
     * @throws DataRequestException
     *             when HttpClient doesn't response
     */
    public DataEntity doRequest() throws DataRequestException {
        return resultAs(DataEntity.class);
    }

    /**
     *
     * Request data from resource and return Customized Class
     *
     * @param clazz
     *            Class T extended from Entity.class to format and receive data
     * @param <T>
     *            Type of class that you want to return the request
     * @return T Class formated data based on a Customized class
     * @throws DataRequestException
     *             when http client doesn`t respond
     */
    public <T> T doRequest(Class<T> clazz) throws DataRequestException {
        return resultAs(clazz);
    }

    /**
     *
     * Request data from resource in an Asynchronous way. It need a callback.
     *
     * @param typeOf
     *            Type of Entity that will return in callback
     * @param <T>
     *            typeOf Type of Entity that will return in callback
     * @param callback
     *            Implement of IDataRequestAsyncCallback to retrieve results. If
     *            it raise a error this exception will be hold on callback
     */
    public <T> void doAsyncRequest(Class<T> typeOf,
            IDataRequestAsyncCallback<T> callback) {
        DataRequestAsync<T> dataRequest = new DataRequestAsync<T>(typeOf,
                getRequest(), callback);
        new Thread(dataRequest).start();
    }

    private <T> T resultAs(Class<T> clazz) throws DataRequestException {
        return new DataResponseParser(getResponse()).parseTo(clazz);
    }

    private DataResponse getResponse() throws DataRequestException {
        return getRequest().request();
    }

    private DataRequest getRequest() {
        return new DataRequest(dpResource);
    }

}
