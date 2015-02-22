package br.com.datapoa;

public class DataPoaProvider implements IDataProvider {

	private final String URL = "http://datapoa.com.br/api/action/";
    private final String DATA_SEARCH = URL + "datastore_search?";
    private final String DATA_UPDATE = URL + "datastore_upsert?";
    private final String DATA_CREATE = URL + "datastore_create?";
    private final String DATA_SQL_SEARCH = URL + "datastore_search_sql?";

	
	@Override
    public String getSiteUrl() {
	    return URL;
    }

	@Override
    public String getDataSearchUrl() {
	    return DATA_SEARCH;
    }

	@Override
    public String getDataUpdateUrl() {
	    return DATA_UPDATE;
    }

	@Override
    public String getDataCreateUrl() {
	    return DATA_CREATE;
    }

	@Override
    public String getDataSearchSqlUrl() {
	    return DATA_SQL_SEARCH;
    }

}
