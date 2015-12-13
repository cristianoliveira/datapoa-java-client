package br.com.datapoa.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class HttpParameterSetParser {

    HttpParameterSet parameters;

    public HttpParameterSetParser(HttpParameterSet parameters) {
        this.parameters = parameters;
    }

    public String asString() throws UnsupportedEncodingException {

        if (this.parameters == null || this.parameters.toList().isEmpty())
            return new String();

        StringBuilder par = new StringBuilder("?");

        for (HttpParameter parameter : this.parameters.toList()) {
            par.append(parameter.getName());
            par.append("=");
            par.append(encode(parameter.getValue()));
            par.append("&");
        }

        return withoutLastCharacter(par);
    }

    private String encode(String value) throws UnsupportedEncodingException {
        return URLEncoder.encode(value, HttpClient.CHARSET);
    }

    private String withoutLastCharacter(StringBuilder stringBuilder) {
        String result = stringBuilder.toString();
        return result.substring(0, result.length() - 1);
    }
}
