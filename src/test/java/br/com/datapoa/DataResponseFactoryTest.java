package br.com.datapoa;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.datapoa.http.HttpResponse;
import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseFactory;
import static org.mockito.Mockito.*;

public class DataResponseFactoryTest extends TestCase {

    @Test
    public void testGivenValidHttpResponseWhenCreateResponseItShouldReturnValidDataPoaResponse() throws IOException {
        // given
        String resultExpected = "Result expected";
        HttpResponse mockedResponse = mock(HttpResponse.class);
        when(mockedResponse.asString()).thenReturn(resultExpected);
        
        // when
        DataResponse response = new DataResponseFactory().createFrom(mockedResponse);
        
        // then
        assertEquals(resultExpected, response.getJsonString());
    }
    
    @Test
    public void testGivenNullHttpResponseWhenCreateResponseItShouldReturnNull() throws IOException {
        // given
        DataResponse resultExpected = null;
        HttpResponse invalidHttpResponse = null;
        
        // when
        DataResponse result = new DataResponseFactory().createFrom(invalidHttpResponse);
        
        // then
        assertEquals(resultExpected, result);
    }

}
