package br.com.datapoa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import br.com.datapoa.entities.DataEntity;
import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseParser;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DataResponseParserTest {
    
    String stubedJsonFromDataPoa;
    
    @Test
    public void testGivenJsonStringWhenParseItShouldReturnInstanceOfClass()
    {
        // given
        String expectedName = "Cristian";
        Integer expectedAge = 20;
        boolean expectedBolean = true;
        
        String jsonStringStubClient = "{ \"name\" : \""+expectedName+"\",  \"age\" : \""+expectedAge+"\", \"isCrazy\" : true }";
        DataResponse mockedResponse = mock(DataResponse.class);
        when(mockedResponse.getJsonString()).thenReturn(jsonStringStubClient);
        
        // when
        StubResultRequest result = new DataResponseParser(mockedResponse).parseTo(StubResultRequest.class);
        
        // then
        assertEquals(expectedName, result.getName());
        assertEquals(expectedAge, result.getAge());
        assertEquals(expectedBolean, result.isCrazy());
        
    }
    
    @Test
    public void testGivenRealJsonStringWhenParseItShouldReturnInstanceDataPoaEntity() throws IOException
    {
        // given
    	ClassLoader classLoader = getClass().getClassLoader();
        byte[] bytes = Files.readAllBytes(Paths.get(classLoader.getResource("json/stub_result_from_datapoa.json").getPath()));
         
        String stubedJsonFromDataPoa = new String(bytes);
    	
    	DataResponse mockedResponse = mock(DataResponse.class);
        when(mockedResponse.getJsonString()).thenReturn(stubedJsonFromDataPoa);
        
        // when
        DataEntity result = new DataResponseParser(mockedResponse).parseTo(DataEntity.class);
        
        // then
        assertNotNull(result);
        assertNotNull(result.getResult());
        assertNotNull(result.getResult().getFields());
        assertNotNull(result.getResult().getRecords());
        
    }
    
    private class StubResultRequest{
        
        private String  name;
        private Integer age;
        private boolean isCrazy;
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        public boolean isCrazy() {
            return isCrazy;
        }
        public void setCrazy(boolean isCrazy) {
            this.isCrazy = isCrazy;
        }

    }
    
}
