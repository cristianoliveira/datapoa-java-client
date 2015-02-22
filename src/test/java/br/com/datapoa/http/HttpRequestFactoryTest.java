package br.com.datapoa.http;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.datapoa.http.HttpMethod;
import br.com.datapoa.http.HttpRequest;
import br.com.datapoa.http.HttpRequestFactory;

public class HttpRequestFactoryTest {

	@Test
	public void testGivenMethodGETWhenGetRequestItShouldReturnHttpRequestWithGETConnecion() throws IOException 
	{
		// given
		String url = "http://stub.com";
		
		HttpMethod method = HttpMethod.GET;
		String resultExpected = method.asString();
		HttpRequestFactory factory = new HttpRequestFactory();
		
		
		// when 
		HttpRequest request = factory.getRequest(method, url, null);
		String result = request.getHttpURLConnection().getRequestMethod();
		
		// then
		assertEquals(resultExpected, result);
	}
	
	@Test
	public void testGivenMethodPOSTWhenGetRequestItShouldReturnHttpRequestWithPOSTConnecion() throws IOException {
		// given
		String url = "http://stub.com";
		
		HttpMethod method = HttpMethod.POST;
		String resultExpected = method.asString();
		HttpRequestFactory factory = new HttpRequestFactory();
		
		
		// when 
		HttpRequest request = factory.getRequest(method, url, null);
		String result = request.getHttpURLConnection().getRequestMethod();
		
		// then
		assertEquals(resultExpected, result);
	}

}
