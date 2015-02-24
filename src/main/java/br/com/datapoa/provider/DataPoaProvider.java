package br.com.datapoa.provider;

public class DataPoaProvider extends DataProvider {

	private String URL = "http://datapoa.com.br/api/action/";
    
	@Override
    public String getSiteUrl() {
	    return URL;
    }

}
