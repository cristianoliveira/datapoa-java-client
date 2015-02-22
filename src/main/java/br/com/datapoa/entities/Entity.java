package br.com.datapoa.entities;

import com.google.gson.JsonObject;

public class Entity {
	

    private String help;
    private boolean success;
    
    private JsonObject error;

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

	public JsonObject getError() {
	    return error;
    }

	public void setError(JsonObject error) {
	    this.error = error;
    }

	public boolean hasError()
	{
		return error != null;
	}

}
