package br.com.datapoa.provider;

public abstract class DataProvider implements IDataProvider {

    private final String DATA_SEARCH = "datastore_search";
    private final String DATA_UPDATE = "datastore_upsert";
    private final String DATA_CREATE = "datastore_create";
    private final String DATA_SQL_SEARCH = "datastore_search_sql";
    private final String PACKAGE_LIST = "package_list";
    private final String PACKAGE_SEARCH = "package_search";
    private final String GROUP_LIST = "group_list";

    @Override
    public String getDataSearchAction() {
        return url(DATA_SEARCH);
    }

    @Override
    public String getDataUpdateAction() {
        return url(DATA_UPDATE);
    }

    @Override
    public String getDataCreateAction() {
        return url(DATA_CREATE);
    }

    @Override
    public String getDataSearchSqlAction() {
        return url(DATA_SQL_SEARCH);
    }

    @Override
    public String getPackageListAction() {
        return url(PACKAGE_LIST);
    }

    @Override
    public String getGroupListAction() {
        return url(GROUP_LIST);
    }

    @Override
    public String getPackageSearchAction() {
        return url(PACKAGE_SEARCH);
    }

    private String url(String action) {
        return new StringBuilder(getSiteUrl()).append(action).toString();
    }

}
