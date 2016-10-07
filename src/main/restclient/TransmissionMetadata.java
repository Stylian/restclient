package main.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;

public class TransmissionMetadata {

	private String response;
	private int statusCode;
	private int contentLength;
	private String contentType;
	private String errorStream;
	private Method requestMethod;
	private Date date;
	private Date expiration;
	private String url;

	public static TransmissionMetadata grabData(HttpURLConnection conn) {
		
		TransmissionMetadata metadata = new TransmissionMetadata();
		
		try {
			StringBuilder jsonOutputBuilder = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output;
			while ((output = br.readLine()) != null) {
				jsonOutputBuilder.append(output);
			}
			
			metadata.setResponse(jsonOutputBuilder.toString());
			metadata.setStatusCode(conn.getResponseCode());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		metadata.setContentType(conn.getContentType());
		metadata.setContentLength(conn.getContentLength());
	//	metadata.setErrorStream(conn.getErrorStream().toString()); // temp
		metadata.setRequestMethod(Method.valueOf(conn.getRequestMethod()));
		metadata.setDate(new Date(conn.getDate()));
		metadata.setExpiration(new Date(conn.getExpiration()));
		metadata.setUrl(conn.getURL().toString());
		
		return metadata;
	}
	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}

	public String getErrorStream() {
		return errorStream;
	}

	public void setErrorStream(String errorStream) {
		this.errorStream = errorStream;
	}

	public Method getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(Method requestMethod) {
		this.requestMethod = requestMethod;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
}
