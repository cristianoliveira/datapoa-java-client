package br.com.datapoa;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataPoaResourceQueryBuilderTest {

	private String expectedAction = DataPoaUrls.DATA_SEARCH;
	private String expectedResourceId = "123";
	private Integer expectedLimit = 1;
	
	@Test
	public void testGiveResourceIdAndLimitWhenBuildItShouldReturnDataPoaResource() {
		// given 
		DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder()
													.resource(expectedResourceId)
													.limit(expectedLimit)
													.action(expectedAction);
		
		// when
		DataPoaResource dpResource = builder.build();
		
	    // then
		assertEquals(expectedAction, dpResource.getAction());
		assertEquals(expectedResourceId, dpResource.getResourceId());
		assertEquals(expectedLimit, dpResource.getLimit());
	}
	
	@Test
	public void testGivenOnlyResourceIdWhenBuildItShouldReturnDataPoaResourceWithoutLimit() {
		// given 
		DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder().resource(expectedResourceId);
		
		// when
		DataPoaResource dpResource = builder.build();
	    
		// then
		assertTrue(dpResource.getLimit() == null);
	}

}
