package com.velocity.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;

import com.velocity.qa.pages.H1TagPages;

public class VerifyH1tag extends TestBase {
	
	
	 H1TagPages tagc;
	
	public VerifyH1tag() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		tagc= new H1TagPages();
		
	}
	
	@Test(priority=0)
	public void VerifyH1TagTest() throws IOException  {
		
		tagc.VerifyH1TagCount();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}


}
