package test.tests;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.restclient.Method;
import main.restclient.ServiceManager;

public class RestTest {

	private ServiceManager serv;
	private Writer writer;
	
	@Before
	public void init() {
		serv = new ServiceManager();	
	}
	
	@Test
	public void get() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.GET);
		Assert.assertEquals("get failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(0), serv.getResponseData().getResponseData());
		Assert.assertEquals(200, serv.getResponseData().getStatusCode());
		Assert.assertEquals("GET", serv.getResponseData().getRequestMethod());
	}

	@Test
	public void post() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts", Method.POST, "{ \"id\": \"1\", \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }");
		Assert.assertEquals("get failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(1), serv.getResponseData().getResponseData());
		Assert.assertEquals(201, serv.getResponseData().getStatusCode());
		Assert.assertEquals("POST", serv.getResponseData().getRequestMethod());
	}
	
	@Test
	public void put() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.PUT, "{ \"id\": \"1\", \"title\": \"foo2\", \"body\": \"bar\", \"userId\": \"1\" }");
		Assert.assertEquals("get failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(2), serv.getResponseData().getResponseData());
		Assert.assertEquals(200, serv.getResponseData().getStatusCode());
		Assert.assertEquals("PUT", serv.getResponseData().getRequestMethod());
	}
	
	@Test
	public void delete() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.DELETE);
		Assert.assertEquals("get failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(3), serv.getResponseData().getResponseData());
		Assert.assertEquals(200, serv.getResponseData().getStatusCode());
		Assert.assertEquals("DELETE", serv.getResponseData().getRequestMethod());
	}
}
