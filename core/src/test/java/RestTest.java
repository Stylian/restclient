package test.java;

//import org.apache.commons.io.FileUtils;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;

//import main.main.java.ServiceManager;

public class RestTest {

//	private ServiceManager serv;
//
//	@Before
//	public void init() {
//		serv = new ServiceManager();
//	}
//
//	@Test
//	public void get() throws IOException {
//		serv.get("http://jsonplaceholder.typicode.com/posts/1");
//		Assert.assertEquals("get failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(0), serv.getMetadata().getResponse());
//		Assert.assertEquals(200, serv.getMetadata().getStatusCode());
//	}
//
//	@Test
//	public void post() throws IOException {
//		serv.post("http://jsonplaceholder.typicode.com/posts", "{ \"id\": \"1\", \"title\": \"foo\", \"body\": \"bar\", \"userId\": \"1\" }");
//		Assert.assertEquals("post failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(1), serv.getMetadata().getResponse());
//		Assert.assertEquals(201, serv.getMetadata().getStatusCode());
//	}
//
//	@Test
//	public void put() throws IOException {
//		serv.put("http://jsonplaceholder.typicode.com/posts/1", "{ \"id\": \"1\", \"title\": \"foo2\", \"body\": \"bar\", \"userId\": \"1\" }");
//		Assert.assertEquals("put failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(2), serv.getMetadata().getResponse());
//		Assert.assertEquals(200, serv.getMetadata().getStatusCode());
//	}
//
//	@Test
//	public void delete() throws IOException {
//		serv.delete("http://jsonplaceholder.typicode.com/posts/1", "");
//		Assert.assertEquals("delete failed" , FileUtils.readLines(new File("src/test/resources/json_responses.txt")).get(3), serv.getMetadata().getResponse());
//		Assert.assertEquals(200, serv.getMetadata().getStatusCode());
//	}
}