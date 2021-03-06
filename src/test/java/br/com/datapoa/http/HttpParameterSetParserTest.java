package br.com.datapoa.http;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import br.com.datapoa.http.HttpParameter;
import br.com.datapoa.http.HttpParameterSet;
import br.com.datapoa.http.HttpParameterSetParser;

public class HttpParameterSetParserTest {

    @Test
    public void testGivenNullWhenParseItShouldReturnEmptyString()
            throws UnsupportedEncodingException {
        // given
        HttpParameterSetParser parser = new HttpParameterSetParser(null);
        String resultExpected = new String();

        // when
        String result = parser.asString();

        // then
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenEmptyHttpParameterSetWhenParseItShouldReturnEmptyString()
            throws UnsupportedEncodingException {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = new String();

        // when
        String result = parser.asString();

        // then
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenOneHttpParameterSetWhenParseItShouldReturnString()
            throws UnsupportedEncodingException {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("pname", "pvalue"));
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = "?pname=pvalue";

        // when
        String result = parser.asString();

        // then
        assertEquals(resultExpected, result);
    }

    @Test
    public void testGivenMoreThanOneHttpParameterSetWhenParseItShouldReturnString()
            throws UnsupportedEncodingException {
        // given
        HttpParameterSet parameters = HttpParameterSet.build();
        parameters.add(new HttpParameter("pname", "pvalue"));
        parameters.add(new HttpParameter("pname2", "pvalue2"));
        parameters.add(new HttpParameter("pname3", "pvalue3"));
        HttpParameterSetParser parser = new HttpParameterSetParser(parameters);
        String resultExpected = "?pname=pvalue&pname2=pvalue2&pname3=pvalue3";

        // when
        String result = parser.asString();

        // then
        assertEquals(resultExpected, result);
    }

}
