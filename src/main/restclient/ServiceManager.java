package main.restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceManager {

	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11"
			+ " (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";
	
	private Writer writer;
	public String JsonOutput;
	
	public ServiceManager(Writer writer) {
		this.writer = writer;
	}
	
	public void send(String path, Method method) throws IOException {
		send(path, method, null, null);
	}
	
	public void send(String path, Method method, String data) throws IOException {
		send(path, method, data, null);
	}
	
	public void send(String path, Method method, String data, String filepath) throws IOException {

		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(method.toString());
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("User-Agent", USER_AGENT);
		
		switch(method) {
		case POST:
		case PUT:
			conn.setDoOutput(true);
			OutputStream os = conn.getOutputStream();
			os.write(data.getBytes("UTF-8"));
			os.flush();
		}

		writer.write("\n------------------------------");
		writer.write("\nRequest Method: " + conn.getRequestMethod());
		writer.write("\nResponse Code: " + conn.getResponseCode());

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		String output;
		JsonOutput = "";
		writer.write("\nOutput from Server .... \n");
		while ((output = br.readLine()) != null) {
			writer.write("\n" + output);
			JsonOutput += output;
		}

		conn.disconnect();
		
		writer.write("\n------------------------------\n");
		
	}
}
