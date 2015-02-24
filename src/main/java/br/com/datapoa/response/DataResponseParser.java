package br.com.datapoa.response;

import com.google.gson.GsonBuilder;

public class DataResponseParser {

    private DataResponse dpResponse;

    public DataResponseParser(DataResponse dpResponse) {
        this.dpResponse = dpResponse;
    }

    public <T> T parseTo(Class<T> clas) {
        return new GsonBuilder().create().fromJson(dpResponse.getJsonString(), clas);
    }
}