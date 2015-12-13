package br.com.datapoa.request;

import java.io.IOException;
import com.google.gson.JsonSyntaxException;

import br.com.datapoa.response.DataResponse;
import br.com.datapoa.response.DataResponseParser;

public final class DataRequestAsync<T> implements Runnable {

    private DataRequest dpRequest;
    private IDataRequestAsyncCallback<T> callback;
    private Class<T> typeOf;

    public DataRequestAsync(Class<T> typeOf, DataRequest dpRequest,
            IDataRequestAsyncCallback<T> callback) {
        this.dpRequest = dpRequest;
        this.typeOf = typeOf;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {

            callback.postProgress("Requesting...");
            DataResponse response;
            try {
                response = dpRequest.request();
            } catch (IOException e) {
                throw new DataRequestException(e, DataRequestException.WHEN_REQUESTING_DATA);
            }

            callback.postProgress("Parsing...");
            T result;
            try {
                result = new DataResponseParser(response).parseTo(typeOf);
            } catch (JsonSyntaxException e) {
                throw new DataRequestException(e, DataRequestException.WHEN_PARSING_DATA);
            }

            callback.postProgress("Posting...");
            try {
                callback.postResult(result);
            } catch (Exception e) {
                throw new DataRequestException(e, DataRequestException.WHEN_POSTING_DATA);
            }

            callback.onFinish();

        } catch (IOException e) {
            callback.postError(e);
        }
    }

}
