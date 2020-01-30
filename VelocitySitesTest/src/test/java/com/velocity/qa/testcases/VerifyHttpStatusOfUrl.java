package com.velocity.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.HttpStatusPages;

public class VerifyHttpStatusOfUrl extends TestBase {
	
	HttpStatusPages checkHttp;
	
	public VerifyHttpStatusOfUrl() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		checkHttp= new HttpStatusPages();
		
	}
	
	@Test(priority=0)
	public void VerifyHttpStatus() throws IOException  {
		
		checkHttp.checkUrlStatus();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
