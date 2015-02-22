package br.com.datapoa.entities;

public class DataPoaEntity {
	
	private String help;
	private boolean success;
	
	private DataPoaResult result;
	
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
	public DataPoaResult getResult() {
		return result;
	}
	public void setResult(DataPoaResult result) {
		this.result = result;
	}
	

}
