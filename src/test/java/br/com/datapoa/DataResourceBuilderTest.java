package br.com.datapoa;

import junit.framework.TestCase;

import org.junit.Test;

import br.com.datapoa.resources.DataResource;
import br.com.datapoa.resources.DataResourceBuilder;

public class DataResourceBuilderTest extends TestCase {

    private String expectedAction = DataPoaCommon.getProvider().getDataSearchAction();
    private String expectedResourceId = "123";
    private Integer expectedLimit = 1;

    @Test
    public void testGiveResourceIdAndLimitWhenBuildItShouldReturnDataPoaResource() {
        // given
        DataResourceBuilder builder =
                new DataResourceBuilder().resource(expectedResourceId).limit(expectedLimit)
                        .action(expectedAction);

        // when
        DataResource dataResource = builder.build();

        // then
        assertEquals(expectedAction, dataResource.getAction());
        assertEquals(expectedResourceId, dataResource.getResourceId());
        assertEquals(expectedLimit, dataResource.getLimit());
    }

    @Test
    public void testGivenOnlyResourceIdWhenBuildItShouldReturnDataPoaResourceWithoutLimit() {
        // given
        DataResourceBuilder builder = new DataResourceBuilder().resource(expectedResourceId);

        // when
        DataResource dataResource = builder.build();

        // then
        assertNull(dataResource.getLimit());
    }

}
