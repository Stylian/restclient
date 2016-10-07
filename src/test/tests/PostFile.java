package test.tests;

import java.io.IOException;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import main.restclient.ServiceManager;

public class PostFile {

	private ServiceManager serv;
	private Writer writer;
	
	@Before
	public void init() {
		serv = new ServiceManager();	
	}
	
	@Test
	public void postFile() throws IOException {
		//TODO
	}
}
