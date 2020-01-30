package com.velocity.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.SourceUrlPage;

public class VerifySrcUrlDomain extends TestBase {
	
	SourceUrlPage srccheck;
	
	public VerifySrcUrlDomain(){
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		
		srccheck = new SourceUrlPage();
		
	}
	
	@Test
	public void VerifySrcUrlsDomain() {
		
		srccheck.verifyDomainOfSrcUrl();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
