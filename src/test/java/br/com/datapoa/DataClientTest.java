package br.com.datapoa;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gson.Gson;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.entities.DataPackages;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceBuilder;

@RunWith(MockitoJUnitRunner.class)
public class DataClientTest extends TestCase{

	String resourceId = "03b349a2-22bd-4de3-9df4-839c2c42d969";
	Integer limit = 5;
	
    @Test
    public void testGivenRealResourceWhenRequestItShouldReturnDataEntity() throws IOException
    {
        //given
    	DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId);
    	DataResource dpResource = builder.build();
    	DataClient dpClient = new DataClient(dpResource);
    	
        // when
    	DataEntity result = dpClient.doRequest();
    	
    	// then
    	assertNotNull(result);
        assertNotNull(result.getResult());
        assertNotNull(result.getResult().getFields());
        assertNotNull(result.getResult().getRecords());
        assertNotNull(result.getResult().getLinks());
       
    }
    
    @Test
    public void testGivenPackageActionItShouldReturnDataPackages() throws IOException
    {
        //given
        String packageRequestAction = DataPoaCommon.getProvider().getPackageListAction();
        DataResourceBuilder builder = new DataResourceBuilder().action(packageRequestAction);
        DataResource dpResource = builder.build();
        DataClient dpClient = new DataClient(dpResource);
        
        // when
        DataPackages result = dpClient.doRequest(DataPackages.class);
        
        // then
        assertNotNull(result);
        assertEquals(true, result.isSuccess());
        assertEquals(false, result.hasError());
        assertNotNull(result.getResult());
       
    }
    
    @Test
    public void testGivenGroupListActionItShouldReturnDataPackages() throws IOException
    {
        //given
        String groupListAction = DataPoaCommon.getProvider().getGroupListAction();
        DataResourceBuilder builder = new DataResourceBuilder().action(groupListAction);
        DataResource dpResource = builder.build();
        DataClient dpClient = new DataClient(dpResource);
        
        // when
        Gson result = dpClient.doRequest(Gson.class);
        
        // then
        assertNotNull(result);
       
    }
    
    @Test
    public void testGivenCustomizedClassResultWhenRequestItShouldReturnCustomizedEntity() throws IOException
    {
        //given
    	DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId);
    	DataResource dpResource = builder.build();
    	DataClient dpClient = new DataClient(dpResource);
    	
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
        DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId).filter("test filter");
        DataResource dpResource = builder.build();
        DataClient dpClient = new DataClient(dpResource);
        
        // when
        DataEntity result = dpClient.doRequest();
        
        // then
        assertNotNull(result);
        assertNotNull(result.getResult());
    }
    
    @Test(expected = IOException.class)
    public void testGivenInvalidRealResourceWhenRequestItShouldRaiseError() throws IOException
    {
        //given
    	DataResourceBuilder builder = new DataResourceBuilder().resource("INVALIDRESOURCE");
    	DataResource dpResource = builder.build();
    	DataClient dpClient = new DataClient(dpResource);
    	
        // when
    	dpClient.doRequest();
    	
    	// then raise IOException 
    }
    
    class StubCustomizedResultEntity extends DataEntity{
    	
    	public boolean isCustomized()
    	{
    		return true;
    	}
    }

}
