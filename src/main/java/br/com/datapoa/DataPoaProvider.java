package br.com.datapoa;

public class DataPoaProvider extends DataProvider {

	private String URL = "http://datapoa.com.br/api/action/";
    
	@Override
    public String getSiteUrl() {
	    return URL;
    }

}
