package br.com.datapoa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import com.google.gson.Gson;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.entities.DataPackages;
import br.com.datapoa.request.IDataRequestAsyncCallback;
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
    public void testGivenRealResourceWhenRequesAsynctItShouldReturnDataEntityInCallback() throws IOException
    {
        //given
        StubCallBack callback = mock(StubCallBack.class);
        DataResourceBuilder builder = new DataResourceBuilder().resource(resourceId);
        DataResource dpResource = builder.build();
        DataClient dpClient = new DataClient(dpResource);
        
        // when
        dpClient.doAsyncRequest(DataEntity.class, callback);
        
        // then
        verify(callback, timeout(5000)).onFinish();
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
    
    class StubCallBack implements IDataRequestAsyncCallback<DataEntity>{
        
        public List<String> progressMessages = new ArrayList<String>();
        public DataEntity expectedResult;
        public Exception exception;
        public boolean finished;

        @Override
        public void postProgress(String progressMessage) {
            progressMessages.add(progressMessage);
        }

        @Override
        public void postResult(DataEntity response) {
            expectedResult = response;
        }

        @Override
        public void postError(Exception exception) {
            this.exception = exception;
        }
        
        public boolean resultIsSuccess()
        {
            return expectedResult.isSuccess();
        }

        @Override
        public void onFinish() {
            finished = true;
        }
    
    }

}
