package br.com.datapoa;

public abstract class DataProvider implements IDataProvider {
    
    private final String DATA_SEARCH = "datastore_search?";
    private final String DATA_UPDATE = "datastore_upsert?";
    private final String DATA_CREATE = "datastore_create?";
    private final String DATA_SQL_SEARCH = "datastore_search_sql?";
    private final String PACKAGE_LIST = "package_list?";
    private final String PACKAGE_SEARCH = "package_search?";
    private final String GROUP_LIST   = "group_list?";

    @Override
    public String getDataSearchUrl() {
        return url(DATA_SEARCH);
    }

    @Override
    public String getDataUpdateUrl() {
        return url(DATA_UPDATE);
    }

    @Override
    public String getDataCreateUrl() {
        return url(DATA_CREATE);
    }

    @Override
    public String getDataSearchSqlUrl() {
        return url(DATA_SQL_SEARCH);
    }

    @Override
    public String getPackageListUrl() {
        return url(PACKAGE_LIST);
    }
    
    @Override
    public String getGroupListUrl() {
        return url(GROUP_LIST);
    }
    
    @Override
    public String getPackageSearchUrl() {
        return url(PACKAGE_SEARCH);
    }
    
    private String url(String action)
    {
        return new StringBuilder(getSiteUrl()).append(action).toString();
    }

}