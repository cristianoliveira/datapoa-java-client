package br.com.datapoa;

import static org.junit.Assert.*;

import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class DataPoaResourceParserTest {

	@Test
	public void testGivenStupResourceWhenParseItShouldReturnFormattedURL() throws MalformedURLException {
		// given
		String stubResourceId = "123";
		Integer limit = 1;
		DataPoaResource dpResource = new DataPoaResourceQueryBuilder()
		                                    .resource(stubResourceId)
											.limit(limit)
											.build();
		String resultExpected = new StringBuilder(DataPoaUrls.DATA_SEARCH).append("resource_id=").append(stubResourceId)
		                                                                  .append("&limit=").append(limit)
		                                                                  .toString();

		// when
		URL resourceURL = DataPoaResourceParser.toUrl(dpResource);

		// then
		assertNotNull(resourceURL);
		assertEquals(resultExpected, resourceURL.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGivenEmptyResourceWhenParseItShouldRaiseExcetpion() throws MalformedURLException {
		// given
		String stubResourceId = "";
		Integer limit = 1;
		DataPoaResource dpResource = new DataPoaResourceQueryBuilder()
		                                                                 .resource(stubResourceId)
		                                                                 .limit(limit)
		                                                                 .build();

		// when
		DataPoaResourceParser.toUrl(dpResource);

		// then	raise IllegalArgumentException
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGivenNullResourceWhenParseItShouldRaiseException() throws MalformedURLException {
		// given
		DataPoaResource dpResource = null;

		// when
		DataPoaResourceParser.toUrl(dpResource);

		// then	raise IllegalArgumentException
	}

}
