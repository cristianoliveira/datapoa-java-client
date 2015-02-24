package br.com.datapoa;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpParameterSetParser;
import br.com.datapoa.resources.DataResourceParser;
import br.com.datapoa.resources.DataResourceUrlBuilder;

public class DataResourceUrlBuilderTest extends TestCase {

    @Test
    public void testGivenActionAndResourceItShouldReturnAnHttpParameterSetClass() throws MalformedURLException {

        // given
        String resource = "someResource123";
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder();
        dataResourceUrlBuilder.withResourceId(resource);
        
        // when
        HttpParameterSet result = dataResourceUrlBuilder.build();

        // then
        assertNotNull(result);
    }
    
    @Test
    public void testGivenActionAndResourceIdItShouldBuildUrlOnlyWithResourceParameter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String resource = "someResource123";
        String resultExpected = "?resource_id="+resource; 
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder();
        dataResourceUrlBuilder.withResourceId(resource);
        
        // when
        HttpParameterSet parameters = dataResourceUrlBuilder.build();
        String result =  new HttpParameterSetParser(parameters).asString();
        

        // then
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenLimitItShouldReturnUrlWithResourceAndLimit() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String resource = "someResource123";
        int limit = 10;
        String resultExpected = "?resource_id="+resource+"&limit="+limit; 
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder();
        dataResourceUrlBuilder.withResourceId(resource);
        dataResourceUrlBuilder.withLimit(limit);
        
        // when
        HttpParameterSet parameters = dataResourceUrlBuilder.build();
        String result =  new HttpParameterSetParser(parameters).asString();
        

        // then
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenFilterItShouldReturnUrlWithResourceAndFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String resource = "someResource123";
        String filter = URLEncoder.encode("some", br.com.datapoa.http.HttpClient.CHARSET);
        String encodedParams  = "?resource_id="+resource+"&q="+filter;
        String resultExpected = encodedParams;
        DataResourceUrlBuilder dataResourceUrlBuilder = new DataResourceUrlBuilder();
        dataResourceUrlBuilder.withResourceId(resource);
        dataResourceUrlBuilder.withFilter(filter);
        
        // when
        HttpParameterSet parameters = dataResourceUrlBuilder.build();
        String result =  new HttpParameterSetParser(parameters).asString();

        // then
        assertEquals(resultExpected, result);
    }

}
