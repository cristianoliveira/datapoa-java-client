package br.com.datapoa;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import br.com.datapoa.entities.DataPoaEntity;

public class DataPoaClientTest {

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
    	assertNotNull(result.getResult());
        assertNotNull(result.getResult().getFields());
        assertNotNull(result.getResult().getRecords());
        assertNotNull(result.getResult().getLinks());
    }

}
