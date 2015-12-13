package br.com.datapoa.request;

public interface IDataRequestAsyncCallback<T> {

    public void postProgress(String progressMessage);

    public void postResult(T response) throws Exception;

    public void postError(Exception exception);

    public void onFinish();
}
