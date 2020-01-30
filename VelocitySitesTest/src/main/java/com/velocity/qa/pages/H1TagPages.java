package com.velocity.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.util.TestUtil;

public class H1TagPages extends TestBase {
	
private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	
	
   public H1TagPages() {
	PageFactory.initElements(driver, this);
}
	
	public void VerifyH1TagCount() {
		
		
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
						 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
						System.out.println("Url Launched : "+siteurl);
					
					
					//driver.get(siteurl);
						driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
					java.util.List<WebElement> h1tag = driver.findElements(By.tagName("H1"));
					 
					 int tagcount=h1tag.size();
					// System.out.println("Number of H1 tag in current url is :"+tagcount);
					 
					 if(tagcount==1) {
						 
						 As.assertTrue(true);
						 //System.out.println("Pass - H1 tag present only once on Url"+siteurl);
						 
					 }else {
						 As.assertTrue(false);
						
						// System.out.println("Fail - Either H1 tag count zero or more on Url"+siteurl);
						 Reporter.log("Fail - Either H1 tag count is "+tagcount+" on Url  "+siteurl);
					 }
					 
					 	
					}
					
					
			}
				
		}
		
		As.assertAll();	
	}catch(Exception e) {
		
	}

}

}