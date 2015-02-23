package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.entities.DataPoaEntity;

public class DataPoaClient {

    private DataPoaResource dpResource;

    public DataPoaClient(DataPoaResource dpResource) {
        this.dpResource = dpResource;
    }

    public DataPoaEntity doRequest() throws IOException {

        return new DataPoaResponseParser(getResponse()).parseTo(DataPoaEntity.class);
    }

    public <T> T doRequest(Class<T> clas) throws IOException {

        return new DataPoaResponseParser(getResponse()).parseTo(clas);
    }

    private DataPoaResponse getResponse() throws IOException
    {
        return new DataPoaRequest(dpResource).request();
    }

}
