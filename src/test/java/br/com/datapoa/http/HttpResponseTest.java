package br.com.datapoa.http;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import br.com.datapoa.http.HttpResponse;

public class HttpResponseTest {

    @Test
    public void testGivenStubInputStreamWhenAsStringItShouldReturnString() throws IOException 
    {
        // given
        String resultExpected = "{ result: 1 }";
        InputStream stubInputStream = new ByteArrayInputStream(resultExpected.getBytes());
        HttpResponse response = new HttpResponse(stubInputStream);
        
        // when
        String result = response.asString();
        
        // then
        assertEquals(resultExpected, result);
    }
    
    public void testGivenNullInputStreamWhenAsStringItShouldReturnNull() throws IOException 
    {
        // given
        HttpResponse response = new HttpResponse(null);
        
        // when
        String result = response.asString();
        
        // then raise IOException
        assertNull(result);
    }

}
