package br.com.datapoa;

import br.com.datapoa.provider.DataPoaProvider;
import br.com.datapoa.provider.IDataProvider;

public final class DataPoaCommon {

    private static IDataProvider provider;

    public static void setProvider(IDataProvider pProvider) {
        provider = pProvider;
    }

    public static IDataProvider getProvider() {
        if (provider == null) {
            provider = new DataPoaProvider();
        }

        return provider;
    }

}
