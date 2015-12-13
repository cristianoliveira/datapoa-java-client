package br.com.datapoa.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class DataResponseParser {

    private DataResponse dpResponse;

    public DataResponseParser(DataResponse dpResponse) {
        this.dpResponse = dpResponse;
    }

    public <T> T parseTo(Class<T> clas) throws JsonSyntaxException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(dpResponse.getJsonString(), clas);
    }
}
