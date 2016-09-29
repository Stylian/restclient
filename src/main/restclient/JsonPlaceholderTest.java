package main.restclient;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class JsonPlaceholderTest {
	
	public static void main(String[] args) {

		Writer writer = new StringWriter();
		
		ServiceManager serv = new ServiceManager(writer);
		
		try {
			//{ "id": "1", "title": "foo2", "body": "bar", "userId": "1" }
			serv.send("http://jsonplaceholder.typicode.com/posts", Method.POST, "{ \"id\": \"1\", \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }");
			serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.PUT, "{ \"id\": \"1\", \"title\": \"foo2\", \"body\": \"bar\", \"userId\": \"1\" }");
			serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.GET);
			serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.DELETE);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(writer.toString());
		
	}

}
