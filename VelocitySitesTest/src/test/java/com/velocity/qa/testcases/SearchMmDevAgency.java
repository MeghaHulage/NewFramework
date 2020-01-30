package com.velocity.qa.testcases;



import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.SearchMmdevOnPages;
import com.velocity.qa.util.TestUtil;

public class SearchMmDevAgency extends TestBase {
	
	
	SearchMmdevOnPages searchmm;
	
	TestUtil test;
	
	
	public SearchMmDevAgency(){
		super();
	}
	
		@BeforeTest
		public void setUp() {
			
			initialization();
	    
			searchmm =new SearchMmdevOnPages();
		}
		
		@Test(priority=0)
		public void verifyMmDevAgency() throws InterruptedException {
			
			//test.writeExcelF();
			
			searchmm.serachMmDev();
			
			 
			 
		}
		
			

			
			
		
		
		@AfterTest
		public void tearDown() {
			
			driver.close();
		}
		

}
