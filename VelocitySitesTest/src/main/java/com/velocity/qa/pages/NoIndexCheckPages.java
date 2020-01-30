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

public class NoIndexCheckPages extends TestBase {
	
private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	
	
	public NoIndexCheckPages() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkNoIndex(){
		
try {
			
			
			SoftAssert As= new SoftAssert();
			File fp=new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx");
			FileInputStream fs= new FileInputStream(fp);
			XSSFWorkbook wk= new XSSFWorkbook(fs);
			XSSFSheet sh= wk.getSheetAt(0);
			
			
		for(int i=0;i<sh.getLastRowNum();i++) {
			
			for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
					
					String siteurl=sh.getRow(i+1).getCell(0).getStringCellValue();
					
					
					if(siteurl.startsWith("https://")) {
						 driver.get(siteurl);
						// Thread.sleep(2000);
						System.out.println("Url Launched : "+siteurl);
						//String title = driver.getTitle();
					
						 Boolean noindexcheck=driver.getPageSource().contains("noindex");
					
						 
						 if(noindexcheck){
							 As.assertFalse(noindexcheck);
							 System.out.println("Fail - noindex term is present");
							 Reporter.log("No Index term is present on url [%s]"+siteurl);
						 }else {
							 
							 As.assertFalse(noindexcheck);
								System.out.println("Pass -noindex term is not present ");
							
																				
							}
					}
					
			}
		}
		As.assertAll();
}catch(Exception e) {
	
}
		
		
		
	}

}
