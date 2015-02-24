package br.com.datapoa;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.datapoa.http.HttpResponse;
import br.com.datapoa.response.DataPoaResponse;
import br.com.datapoa.response.DataPoaResponseFactory;
import static org.mockito.Mockito.*;

public class DataResponseFactoryTest extends TestCase {

    @Test
    public void testGivenValidHttpResponseWhenCreateResponseItShouldReturnValidDataPoaResponse() throws IOException {
        // given
        String resultExpected = "Result expected";
        HttpResponse mockedResponse = mock(HttpResponse.class);
        when(mockedResponse.asString()).thenReturn(resultExpected);
        
        // when
        DataPoaResponse response = new DataPoaResponseFactory().createFrom(mockedResponse);
        
        // then
        assertEquals(resultExpected, response.getJsonString());
    }
    
    @Test
    public void testGivenNullHttpResponseWhenCreateResponseItShouldReturnNull() throws IOException {
        // given
        DataPoaResponse resultExpected = null;
        HttpResponse invalidHttpResponse = null;
        
        // when
        DataPoaResponse result = new DataPoaResponseFactory().createFrom(invalidHttpResponse);
        
        // then
        assertEquals(resultExpected, result);
    }

}
