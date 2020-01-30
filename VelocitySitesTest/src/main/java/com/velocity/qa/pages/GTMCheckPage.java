package com.velocity.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;

public class GTMCheckPage extends TestBase {
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	
	
	public GTMCheckPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkGTM() {
		
		SoftAssert As= new SoftAssert();
		driver.get(prop.getProperty("url"));
		
     Boolean gtm=driver.getPageSource().contains("(window,document,'script','dataLayer', 'GTM-");
		
		if(gtm){
			
			As.assertTrue(true);
			//System.out.println("GTM 1st present");
		   
		}else {
			As.assertTrue(false);
			//System.out.println("GTM 1st not present");
			Reporter.log("GTM 1st not present");
			
		}
		
		Boolean igtm=driver.getPageSource().contains("//www.googletagmanager.com/ns.html?id=GTM-");
		if(igtm) {
			As.assertTrue(true);
			//System.out.println("GTM 2nd present");
			
		}else {
			As.assertTrue(false);
			//System.out.println("GTM 2nd not present");
			Reporter.log("GTM 2nd not present");
		}
		
		
	As.assertAll();	
		
		
	}

}
