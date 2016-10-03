package main.restclient;

public class ServiceResponse {

	private String responseData;
	private String requestMethod;
	private int statusCode;
	
	public ServiceResponse(String responseData, String requestMethod, int statusCode) {
		this.responseData = responseData;
		this.requestMethod = requestMethod;
		this.statusCode = statusCode;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
}
