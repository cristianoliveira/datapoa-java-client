package br.com.datapoa;

import org.mockito.runners.MockitoJUnitRunner;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpParameterSetParser;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceParser;
import br.com.datapoa.resources.DataResourceBuilder;

@RunWith(MockitoJUnitRunner.class)
public class DataResourceParserTest extends TestCase {

    @Test
    public void testGivenStupResourceWhenParseItShouldReturnFormattedURL() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer limit = 1;
        DataResource dpResource = new DataResourceBuilder()
                                            .resource(stubResourceId)
                                            .limit(limit)
                                            .build();
        String resultExpected = new StringBuilder()
                                                 .append("?resource_id=").append(stubResourceId)
                                                 .append("&limit=").append(limit)
                                                 .toString();

        // when
        HttpParameterSet resourceURL = DataResourceParser.toHttpParameterSet(dpResource);
        String result =  new HttpParameterSetParser(resourceURL).asString();

        // then
        assertNotNull(resourceURL);
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenNewActionWhenParseItShouldReturnFormattedURL() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer limit = 1;
        DataResource dpResource = new DataResourceBuilder()
                                            .resource(stubResourceId)
                                            .limit(limit)
                                            .build();
        String resultExpected = new StringBuilder()
                                                 .append("?resource_id=").append(stubResourceId)
                                                 .append("&limit=").append(limit)
                                                 .toString();

        // when
        HttpParameterSet parameters = DataResourceParser.toHttpParameterSet(dpResource);
        String result =  new HttpParameterSetParser(parameters).asString();

        // then
        assertNotNull(parameters);
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenFilterWhenParseItShouldReturnFormattedURLWithFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer expectedLimit = 1;
        String expectedFilter = "Teste";
        
        DataResource dpResource = new DataResourceBuilder()
                                            .resource(stubResourceId)
                                            .limit(expectedLimit)
                                            .filter(expectedFilter)
                                            .build();
        String resultExpected = new StringBuilder()
                                                 .append("?resource_id=").append(stubResourceId)
                                                 .append("&q=").append(expectedFilter)
                                                 .append("&limit=").append(expectedLimit)
                                                 .toString();

        // when
        HttpParameterSet parameters = DataResourceParser.toHttpParameterSet(dpResource);
        String result =  new HttpParameterSetParser(parameters).asString();

        // then
        assertNotNull(parameters);
        assertEquals(resultExpected, result);
    }
    
    @Test
    public void testGivenFilterWithSpacesWhenParseItShouldReturnFormattedURLWithFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer expectedLimit = 1;
        String expectedFilter = "Test with spaces";
        
        String actionExpected = DataPoaCommon.getProvider().getPackageListAction();
        DataResource dpResource = new DataResourceBuilder().action(actionExpected)
                                            .resource(stubResourceId)
                                            .limit(expectedLimit)
                                            .filter(expectedFilter)
                                            .build();
        String resultExpected = new StringBuilder().append("?resource_id=").append(stubResourceId)
                                                   .append("&q=").append(URLEncoder.encode(expectedFilter, HttpClient.CHARSET))
                                                   .append("&limit=").append(expectedLimit)
                                                   .toString();
        
        // when
        HttpParameterSet parameters = DataResourceParser.toHttpParameterSet(dpResource);
        String result =  new HttpParameterSetParser(parameters).asString();

        // then
        assertNotNull(parameters);
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenEmptyResourceWhenParseItShouldReturnParameters() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "";
        Integer limit = 1;
        DataResource dpResource = new DataResourceBuilder().resource(stubResourceId)
                                                                      .limit(limit)
                                                                      .build();

        // when
        HttpParameterSet parameter = DataResourceParser.toHttpParameterSet(dpResource);

        // then    raise IllegalArgumentException
        assertNotNull(parameter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGivenNullResourceWhenParseItShouldRaiseException() throws MalformedURLException, UnsupportedEncodingException {
        // given
        DataResource dpResource = null;

        // when
        DataResourceParser.toHttpParameterSet(dpResource);

        // then    raise IllegalArgumentException
    }

}
