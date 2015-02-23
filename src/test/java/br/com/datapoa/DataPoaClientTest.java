package br.com.datapoa;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.datapoa.entities.DataPoaEntity;

@RunWith(MockitoJUnitRunner.class)
public class DataPoaClientTest extends TestCase{

	String resourceId = "03b349a2-22bd-4de3-9df4-839c2c42d969";
	Integer limit = 5;
	
    @Test
    public void testGivenRealResourceWhenRequestItShouldReturnDataPoaEntity() throws IOException
    {
        //given
    	DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder().resource(resourceId);
    	DataPoaResource dpResource = builder.build();
    	DataPoaClient dpClient = new DataPoaClient(dpResource);
    	
        // when
    	DataPoaEntity result = dpClient.doRequest();
    	
    	// then
    	assertNotNull(result);
    	assertEquals(true, result.isSuccess());
        assertEquals(false, result.hasError());
        assertNotNull(result.getResult());
        assertNotNull(result.getResult().getFields());
        assertNotNull(result.getResult().getRecords());
        assertNotNull(result.getResult().getLinks());
       
    }
    
    @Test
    public void testGivenCustomizedClassResultWhenRequestItShouldReturnCustomizedEntity() throws IOException
    {
        //given
    	DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder().resource(resourceId);
    	DataPoaResource dpResource = builder.build();
    	DataPoaClient dpClient = new DataPoaClient(dpResource);
    	
        // when
    	StubCustomizedResultEntity result = dpClient.doRequest(StubCustomizedResultEntity.class);
    	
    	// then
    	assertNotNull(result);
    	assertTrue(result.isCustomized());
    	
    	// and also 
    	assertNotNull(result.getResult());
        assertNotNull(result.getResult().getFields());
        assertNotNull(result.getResult().getRecords());
        assertNotNull(result.getResult().getLinks());
    }
    
    @Test
    public void testGivenFilterResultWhenRequestItShouldReturnDataPoaEntity() throws IOException
    {
        //given
        DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder().resource(resourceId).filter("test filter");
        DataPoaResource dpResource = builder.build();
        DataPoaClient dpClient = new DataPoaClient(dpResource);
        
        // when
        DataPoaEntity result = dpClient.doRequest();
        
        // then
        assertNotNull(result);
        assertNotNull(result.getResult());
    }
    
    @Test(expected = IOException.class)
    public void testGivenInvalidRealResourceWhenRequestItShouldRaiseError() throws IOException
    {
        //given
    	DataPoaResourceQueryBuilder builder = new DataPoaResourceQueryBuilder().resource("INVALIDRESOURCE");
    	DataPoaResource dpResource = builder.build();
    	DataPoaClient dpClient = new DataPoaClient(dpResource);
    	
        // when
    	dpClient.doRequest();
    	
    	// then raise IOException 
    }
    
    class StubCustomizedResultEntity extends DataPoaEntity{
    	
    	public boolean isCustomized()
    	{
    		return true;
    	}
    }

}
