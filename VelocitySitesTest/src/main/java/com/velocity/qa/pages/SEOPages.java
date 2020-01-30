package com.velocity.qa.pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;

public class SEOPages extends TestBase {
	
	
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	
	
	public SEOPages() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void checkSEO() {
		
		
try {
			
			
			SoftAssert As= new SoftAssert();
			File fp=new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx");
			FileInputStream fs= new FileInputStream(fp);
			XSSFWorkbook wk= new XSSFWorkbook(fs);
			XSSFSheet sh= wk.getSheetAt(0);
			
		for(int i=0;i<sh.getLastRowNum();i++) {
			
			for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
					
					String siteurl=sh.getRow(i+1).getCell(0).getStringCellValue();
					 if(siteurl.startsWith(prop.getProperty("url"))) {
						 driver.get(siteurl);
						 Thread.sleep(2000);
						System.out.println("Url Launched : "+siteurl);
						
					
					 Boolean SEOcheck=driver.getTitle().contains(prop.getProperty("location"));
						
					 
					 if(SEOcheck){
						 
						As.assertTrue(SEOcheck); 
						 
						 System.out.println("shows window title :"+ driver.getTitle());
							System.out.println("SEO Pass on URL  " );
							 System.out.println("_____________________________________________________");
							
						
						   
						}else {
							
							As.assertFalse(SEOcheck);
						
							System.out.println("shows window title :"+ driver.getTitle());
							System.out.println("SEO Fail on URL  ");
							 System.out.println("_____________________________________________________");
							 Reporter.log("SEO Fail on URL which shows window title [%s]"+driver.getTitle());
							
						}
					 }
					
					
					
					
			}
		}
		
		As.assertAll();
		
	}catch(Exception e) {
		 e.printStackTrace();
		 
	 }
		
		
	}
	

}
