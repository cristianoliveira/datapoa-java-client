package br.com.datapoa.request;

import java.io.IOException;

public class DataRequestException extends IOException {
    private static final long serialVersionUID = 1L;

    public static int WHEN_REQUESTING_DATA = 1;
    public static int WHEN_PARSING_DATA = 2;
    public static int WHEN_POSTING_DATA = 3;
    public static int WHEN_PARSING_RESOURCE = 4;

    private int pointOfError;

    DataRequestException(Exception innerException, Integer point) {
        super(innerException);
        this.pointOfError = point;
    }

    public int getPointOfError() {
        return this.pointOfError;
    }

}
