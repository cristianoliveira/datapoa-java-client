package br.com.datapoa;

public class DataPoaCommon {
	
	private static IDataProvider provider;
	
	public static void setProvider(IDataProvider pProvider)
	{
		provider = pProvider;
	}
	
	public static IDataProvider getProvider()
	{
		if(provider == null)
		{
			return new DataPoaProvider();
		} 
		else
		{
			return provider;	
		}
	}

}
