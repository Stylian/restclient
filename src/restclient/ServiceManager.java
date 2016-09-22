package restclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ServiceManager {

	private Writer writer;
	
	public ServiceManager(Writer writer) {
		this.writer = writer;
	}
	
	public void send(String path, Method method) {
		send(path, method, null);
	}
	
	public void send(String path, Method method, String data) {
		try {

			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method.toString());
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11"
					+ " (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			
			switch(method) {
			case POST:
			case PUT:
				conn.setDoOutput(true);
				OutputStream os = conn.getOutputStream();
				os.write(data.getBytes("UTF-8"));
				os.flush();
			}

			System.out.println("Request Method: " + conn.getRequestMethod());
			System.out.println("Response Code: " + conn.getResponseCode());

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
