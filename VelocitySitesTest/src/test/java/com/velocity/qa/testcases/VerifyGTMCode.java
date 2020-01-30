package com.velocity.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.GTMCheckPage;


public class VerifyGTMCode extends TestBase {
	
	GTMCheckPage GTMcheck;
	
	public VerifyGTMCode() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		GTMcheck= new GTMCheckPage();
		
	}
	
	@Test(priority=0)
	public void VerifyGTMCodePresent() throws IOException  {
		
		GTMcheck.checkGTM();
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		
	}

}
