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
		writer = new StringWriter();
		serv = new ServiceManager(writer);	
	}
	
	@Test
	public void get() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.GET);
		Assert.assertEquals("get failed" , FileUtils.readFileToString(new File("src/test/resources/get.txt")), serv.JsonOutput);
	}

	@Test
	public void post() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts", Method.POST, "{ \"id\": \"1\", \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }");
		System.out.println(writer);
	}
	
	@Test
	public void put() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.PUT, "{ \"id\": \"1\", \"title\": \"foo2\", \"body\": \"bar\", \"userId\": \"1\" }");
		System.out.println(writer);
	}
	
	@Test
	public void delete() throws IOException {
		serv.send("http://jsonplaceholder.typicode.com/posts/1", Method.DELETE);
		System.out.println(writer);
	}
}
