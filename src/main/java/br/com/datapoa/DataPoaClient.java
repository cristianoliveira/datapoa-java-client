package br.com.datapoa;

import java.io.IOException;

import br.com.datapoa.entities.DataPoaEntity;

public class DataPoaClient {

    private DataPoaResource dpResource;

    public DataPoaClient(DataPoaResource dpResource) {
        this.dpResource = dpResource;
    }

    public DataPoaEntity doRequest() throws IOException {
        DataPoaRequest request = new DataPoaRequest(dpResource);
        DataPoaResponse dpResponse = request.request();
        return new DataPoaResponseParser(dpResponse).parseTo(DataPoaEntity.class);
    }

    public <T> T doRequest(Class<T> clas) throws IOException {
        DataPoaRequest request = new DataPoaRequest(dpResource);
        DataPoaResponse dpResponse = request.request();
        return new DataPoaResponseParser(dpResponse).parseTo(clas);
    }

}
