package br.com.datapoa;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.datapoa.resources.DataResourceUrlBuilder;

public class DataResourceUrlBuilderTest extends TestCase {

    @Test
    public void testGivenActionAndResourceItShouldReturnAnUrlClass() throws MalformedURLException {

        // given
        String action = "http://somesite.com";
        String resource = "someResource123";
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder(action, resource);
        
        // when
        Object result = dataResourceUrlBuilder.build();

        // then
        assertEquals(result.getClass(), URL.class);
    }
    
    @Test
    public void testGivenActionAndResourceIdItShouldBuildUrlOnlyWithResourceParameter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String action = "http://somesite.com";
        String resource = "someResource123";
        String resultExpected = action + "?" + "resource_id="+resource; 
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder(action, resource);
        
        // when
        URL result = dataResourceUrlBuilder.build();

        // then
        assertEquals(resultExpected, result.toString());
    }

    @Test
    public void testGivenLimitItShouldReturnUrlWithResourceAndLimit() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String action = "http://somesite.com";
        String resource = "someResource123";
        int limit = 10;
        String resultExpected = action + "?" + "resource_id="+resource+"&limit="+limit; 
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder(action, resource);
        dataResourceUrlBuilder.withLimit(limit);
        
        // when
        URL result = dataResourceUrlBuilder.build();

        // then
        assertEquals(resultExpected, result.toString());
    }

    @Test
    public void testGivenFilterItShouldReturnUrlWithResourceAndFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String action = "http://somesite.com/action";
        String resource = "someResource123";
        String filter = URLEncoder.encode("some", br.com.datapoa.http.HttpClient.CHARSET);
        String encodedParams  = "?resource_id="+resource+"&q="+filter;
        String resultExpected = action + encodedParams;
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder(action, resource);
        dataResourceUrlBuilder.withFilter(filter);
        
        // when
        URL result = dataResourceUrlBuilder.build();

        // then
        assertEquals(resultExpected, result.toString());
    }

}
