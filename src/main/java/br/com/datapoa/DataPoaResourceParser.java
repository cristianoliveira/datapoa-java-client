package br.com.datapoa;

import java.net.MalformedURLException;
import java.net.URL;

public class DataPoaResourceParser {

	public static URL toUrl(DataPoaResource dpResource)
	                throws MalformedURLException {
		if (dpResource == null || dpResource.getResourceId().isEmpty())
			throw new IllegalArgumentException(
			                "DataPoaResource must to be informed.");

		StringBuilder url = new StringBuilder(dpResource.getAction());
		url.append("resource_id=" + dpResource.getResourceId());

		if (dpResource.getLimit() != null)
			url.append("&limit=" + dpResource.getLimit());

		return new URL(url.toString());
	}

}
