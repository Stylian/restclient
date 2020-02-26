package main.java;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;

public class ServiceManager {

	public static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11"
			+ " (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";

//	private TransmissionMetadata metadata;
//	private File file;
//
//	public ServiceManager() { }
//
//	public void get(String path) throws IOException {
//		get(path, null);
//	}
//
//	public void get(String path, String data) throws IOException {
//		send(path, Method.GET, data);
//	}
//
//	public void post(String path) throws IOException {
//		post(path, null);
//	}
//
//	public void post(String path, String data) throws IOException {
//		send(path, Method.POST, data);
//	}
//
//	public void put(String path) throws IOException {
//		put(path, null);
//	}
//
//	public void put(String path, String data) throws IOException {
//		send(path, Method.PUT, data);
//	}
//
//	public void delete(String path) throws IOException {
//		delete(path, null);
//	}
//
//	public void delete(String path, String data) throws IOException {
//		send(path, Method.DELETE, data);
//	}
//
//	public void send(String path, Method method, String data) throws IOException {
//
//		HttpURLConnection conn = sendRequest(path, method);
//
//		if(method.equals(Method.POST) || method.equals(Method.PUT)) {
//			attachData(conn, data);
//		}
//		metadata = TransmissionMetadata.grabData(conn);
//
//		conn.disconnect();
//
//	}
//
//	public ServiceManager addFile(File file) {
//		this.file = file;
//		return this;
//	}
//
//	private HttpURLConnection sendRequest(String path, Method method) throws IOException {
//		URL url = new URL(path);
//		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//		conn.setRequestMethod(method.toString());
//		conn.setRequestProperty("Content-Type", "application/json");
//		conn.setRequestProperty("Accept", "application/json");
//		conn.setRequestProperty("User-Agent", USER_AGENT);
//		return conn;
//	}
//
//	private void attachData(HttpURLConnection conn, String data) throws IOException {
//		conn.setDoOutput(true);
//		OutputStream os = conn.getOutputStream();
//		if(data != null) {
//			os.write(data.getBytes("UTF-8"));
//		}
//		if(file != null) {
//			Files.copy(file.toPath(), os);
//		}
//	}
//
//	public TransmissionMetadata getMetadata() {
//		return metadata;
//	}

}
