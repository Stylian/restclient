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
