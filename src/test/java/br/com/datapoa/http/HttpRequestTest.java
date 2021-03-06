package br.com.datapoa.http;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import br.com.datapoa.http.HttpRequest;
import br.com.datapoa.http.HttpResponse;

public class HttpRequestTest {

    @Test
    public void testGivenHttpConnectionWhenDoRequestItShouldReturnHttpResponse() throws IOException {
        // given
        InputStream stubInputStream = new ByteArrayInputStream("{ result:0 }".getBytes());

        HttpURLConnection mockedHttpConnection = mock(HttpURLConnection.class);
        when(mockedHttpConnection.getInputStream()).thenReturn(stubInputStream);

        HttpRequest httpRequest = new HttpRequest(mockedHttpConnection);

        // when
        HttpResponse response = httpRequest.doRequest();

        // then
        assertNotNull(response);
    }

}
