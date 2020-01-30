package com.velocity.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.NoIndexCheckPages;
import com.velocity.qa.pages.SearchMmdevOnPages;
import com.velocity.qa.util.TestUtil;

public class VerifyNoIndex extends TestBase {
	
	NoIndexCheckPages cehckNoIndex;
	
	
	
	public VerifyNoIndex(){
		super();
	}
	
		@BeforeTest
		public void setUp() {
			
			initialization();
	    
			cehckNoIndex =new NoIndexCheckPages();
		}
		
		@Test(priority=0)
		public void verifyNoIndextest() throws InterruptedException {
			
			cehckNoIndex.checkNoIndex();
			
			 
			 
		}
		
			

			
			
		
		
		@AfterTest
		public void tearDown() {
			
			driver.close();
		}
		

	
	

}
