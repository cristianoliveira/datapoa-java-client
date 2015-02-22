package br.com.datapoa.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpRequest {

    private HttpURLConnection httpConnection;

    public HttpRequest(HttpURLConnection httpConnection) {
        this.httpConnection = httpConnection;
    }

    public HttpResponse doRequest() throws IOException {

        InputStream inStream = httpConnection.getInputStream();

        return new HttpResponse(inStream);
    }

    public HttpURLConnection getHttpURLConnection() {
        return httpConnection;
    }
}
