package br.com.datapoa.response;

import java.io.IOException;

import br.com.datapoa.http.HttpResponse;

public final class DataResponseFactory {

    /**
     * 
     * Create a DataResponse based on a HttpResponse
     * 
     * @param httpRespose
     *            HttpResponse result of a HttpRequest
     * @return DataResponse with json from HttpResponse, null when HttpResponse
     *         null
     * @throws IOException
     *             when try to parse HttpResponse to String
     */
    public static DataResponse createFrom(HttpResponse httpRespose)
            throws IOException {
        if (httpRespose == null)
            return null;

        DataResponse response = new DataResponse();
        response.setJsonString(httpRespose.asString());

        return response;
    }

}
