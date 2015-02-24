package br.com.datapoa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.request.DataRequest;
import br.com.datapoa.request.DataRequestAsync;
import br.com.datapoa.request.IDataRequestAsyncCallback;
import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceBuilder;

public class DataRequestAsyncTest {

    String resourceId = "03b349a2-22bd-4de3-9df4-839c2c42d969";
    Integer limit = 5;
    
    @Test
    public void testGivenResourceItShoulToRequestAndReturnInRequestCallback() {
        //given 
        StubCallBack stubCallback = new StubCallBack();
        DataResource dpResource = new DataResourceBuilder().resource(resourceId).limit(limit).build();
        DataRequest dRequest = new DataRequest(dpResource);
        
        // when
        DataRequestAsync<DataEntity> asyncRequest = new DataRequestAsync<DataEntity>(DataEntity.class, dRequest, stubCallback);
        asyncRequest.run();
        
        DataEntity result = stubCallback.expectedResult;
        
        // then
        assertNotNull(result);
        assertNotNull(result.getHelp());
    }

    class StubCallBack implements IDataRequestAsyncCallback<DataEntity>{
        
        public List<String> progressMessages = new ArrayList<String>();
        public DataEntity expectedResult;
        public Exception exception;
        public boolean isFinished;

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

        @Override
        public void onFinish() {
            isFinished = true;
        }
    
    }

}
