package br.com.datapoa;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DataPoaResponseParserTest {
    
    String stubedJsonFromDataPoa;
    
    @Before
    public void setUp()
    {
        
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("json/stub_result_from_datapoa.json");
        File file = new File(classLoader.getResource("json/stub_result_from_datapoa.json").getFile());
        stubedJsonFromDataPoa = file.toString();
        
    }
    
    @Test
    public void testGivenJsonStringWhenParseItShouldReturnInstanceOfClass()
    {
        // given
        String expectedName = "Cristian";
        Integer expectedAge = 20;
        boolean expectedBolean = true;
        
        String jsonStringStubClient = "{ \"name\" : \""+expectedName+"\",  \"age\" : \""+expectedAge+"\", \"isCrazy\" : true }";
        DataPoaResponse mockedResponse = mock(DataPoaResponse.class);
        when(mockedResponse.getJsonString()).thenReturn(jsonStringStubClient);
        
        // when
        StubResultRequest result = new DataPoaResponseParser(mockedResponse).parseTo(StubResultRequest.class);
        
        // then
        assertEquals(expectedName, result.getName());
        assertEquals(expectedAge, result.getAge());
        assertEquals(expectedBolean, result.isCrazy());
        
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
