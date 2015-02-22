package br.com.datapoa.http;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.datapoa.http.HttpClient;
import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpParameter;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpResponse;

@RunWith(MockitoJUnitRunner.class)
public class HttpClientTest {

	@Test
	public void testGivenOnlyUrlWhenGetRequestItShouldReturnHttpResponse() throws IOException 
	{
		// given
		HttpClient httpClient = new HttpClient(HttpMethod.GET);
		String googleUrl = "http://google.com";
		
		// when
		HttpResponse response = httpClient.request(googleUrl);
		
		// then
		assertEquals(response.getClass(), HttpResponse.class);
	}
	
	@Test
	public void testGivenValidParametersWhenGetRequestItShouldReturnHttpResponse() throws IOException
	{
		// given
		HttpClient httpClient = new HttpClient(HttpMethod.GET);
		String googleUrl = "http://google.com";
		HttpParameterSet parameters = HttpParameterSet.build();
		parameters.add(new HttpParameter("q","Test"));
		
		// when
		HttpResponse response = httpClient.request(googleUrl);
		
		// then
		assertEquals(response.getClass(), HttpResponse.class);
	}
	
	@Test
	public void testGivenURLWhenGetRequestItShouldReturnHttpResponse() throws IOException
	{
		// given
		HttpClient httpClient = new HttpClient(HttpMethod.GET);
		URL googleUrl = new URL("http://google.com");
		HttpParameterSet parameters = HttpParameterSet.build();
		parameters.add(new HttpParameter("q","Test"));
		
		// when
		HttpResponse response = httpClient.request(googleUrl);
		
		// then
		assertEquals(response.getClass(), HttpResponse.class);
	}
	

	@Test(expected = IllegalArgumentException.class)
	public void testGivenInvalidUrlWhenGetRequestItShouldRaiseExceotion() throws IOException 
	{
		// given
		HttpClient httpClient = new HttpClient(HttpMethod.POST);
		String invalidUrl = "http://";
		
		// when
		httpClient.request(invalidUrl);
		
		// then raise IllegalArgumentException
	}
	

}
