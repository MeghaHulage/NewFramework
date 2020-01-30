package com.velocity.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.HttpStatusPages;
import com.velocity.qa.pages.SEOPages;


public class VerifySEOLocation extends TestBase {
	
	SEOPages checSEOLoc;
	
	public VerifySEOLocation() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		checSEOLoc= new SEOPages();
		
	}
	
	@Test(priority=0)
	public void VerifySEOLocation() throws IOException  {
		
		checSEOLoc.checkSEO();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
