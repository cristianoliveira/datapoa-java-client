package br.com.datapoa;

import org.mockito.runners.MockitoJUnitRunner;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class DataPoaResourceParserTest extends TestCase {

    @Test
    public void testGivenStupResourceWhenParseItShouldReturnFormattedURL() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer limit = 1;
        DataPoaResource dpResource = new DataPoaResourceQueryBuilder()
                                            .resource(stubResourceId)
                                            .limit(limit)
                                            .build();
        String resultExpected = new StringBuilder(DataPoaCommon.getProvider().getDataSearchUrl())
                                                 .append("resource_id=").append(stubResourceId)
                                                 .append("&limit=").append(limit)
                                                 .toString();

        // when
        URL resourceURL = DataPoaResourceParser.toUrl(dpResource);

        // then
        assertNotNull(resourceURL);
        assertEquals(resultExpected, resourceURL.toString());
    }
    
    @Test
    public void testGivenNewActionWhenParseItShouldReturnFormattedURL() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer limit = 1;
        String actionExpected = DataPoaCommon.getProvider().getPackageListUrl();
        DataPoaResource dpResource = new DataPoaResourceQueryBuilder().action(actionExpected)
                                            .resource(stubResourceId)
                                            .limit(limit)
                                            .build();
        String resultExpected = new StringBuilder(actionExpected)
                                                 .append("resource_id=").append(stubResourceId)
                                                 .append("&limit=").append(limit)
                                                 .toString();

        // when
        URL resourceURL = DataPoaResourceParser.toUrl(dpResource);

        // then
        assertNotNull(resourceURL);
        assertEquals(resultExpected, resourceURL.toString());
    }
    
    @Test
    public void testGivenFilterWhenParseItShouldReturnFormattedURLWithFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer expectedLimit = 1;
        String expectedFilter = "Teste";
        
        String actionExpected = DataPoaCommon.getProvider().getPackageListUrl();
        DataPoaResource dpResource = new DataPoaResourceQueryBuilder().action(actionExpected)
                                            .resource(stubResourceId)
                                            .limit(expectedLimit)
                                            .filter(expectedFilter)
                                            .build();
        String resultExpected = new StringBuilder(actionExpected)
                                                 .append("resource_id=").append(stubResourceId)
                                                 .append("&q=").append(expectedFilter)
                                                 .append("&limit=").append(expectedLimit)
                                                 .toString();

        // when
        URL resourceURL = DataPoaResourceParser.toUrl(dpResource);

        // then
        assertNotNull(resourceURL);
        assertEquals(resultExpected, resourceURL.toString());
    }
    
    @Test
    public void testGivenFilterWithSpacesWhenParseItShouldReturnFormattedURLWithFilter() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "123";
        Integer expectedLimit = 1;
        String expectedFilter = "Test with spaces";
        
        String actionExpected = DataPoaCommon.getProvider().getPackageListUrl();
        DataPoaResource dpResource = new DataPoaResourceQueryBuilder().action(actionExpected)
                                            .resource(stubResourceId)
                                            .limit(expectedLimit)
                                            .filter(expectedFilter)
                                            .build();
        String resultExpected = new StringBuilder(actionExpected)
                                                 .append("resource_id=").append(stubResourceId)
                                                 .append("&q=").append(expectedFilter)
                                                 .append("&limit=").append(expectedLimit)
                                                 .toString();

        // when
        URL resourceURL = DataPoaResourceParser.toUrl(dpResource);

        // then
        assertNotNull(resourceURL);
        assertEquals(resultExpected, resourceURL.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGivenEmptyResourceWhenParseItShouldRaiseExcetpion() throws MalformedURLException, UnsupportedEncodingException {
        // given
        String stubResourceId = "";
        Integer limit = 1;
        DataPoaResource dpResource = new DataPoaResourceQueryBuilder().resource(stubResourceId)
                                                                      .limit(limit)
                                                                      .build();

        // when
        DataPoaResourceParser.toUrl(dpResource);

        // then    raise IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGivenNullResourceWhenParseItShouldRaiseException() throws MalformedURLException, UnsupportedEncodingException {
        // given
        DataPoaResource dpResource = null;

        // when
        DataPoaResourceParser.toUrl(dpResource);

        // then    raise IllegalArgumentException
    }

}
