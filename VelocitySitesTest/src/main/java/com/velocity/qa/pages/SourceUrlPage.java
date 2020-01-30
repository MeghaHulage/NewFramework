package com.velocity.qa.pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;

public class SourceUrlPage extends TestBase{
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	XSSFWorkbook wk;
	XSSFSheet sh;
	public SourceUrlPage() {
		PageFactory.initElements(driver, this);
	
		
	}
	
	public void verifyDomainOfSrcUrl() {
		
		try {
			
			SoftAssert as= new SoftAssert();
			File fp=new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx");
			FileInputStream fs= new FileInputStream(fp);
			XSSFWorkbook wk= new XSSFWorkbook(fs);
			XSSFSheet sh= wk.getSheetAt(0);
				
				for(int i=0;i<sh.getLastRowNum();i++) {
					
					for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
							
							String linkurl=sh.getRow(i+1).getCell(0).getStringCellValue();
							
							System.out.println("Url Launched : "+linkurl);
							
							java.util.List<WebElement> srclinks = driver.findElements(By.tagName("img"));
							
							for(int k=0;k<srclinks.size();k++) {
								
								String srcurl= srclinks.get(k).getAttribute("src");
								
								if(srcurl.startsWith(prop.getProperty("url")) ||srcurl.startsWith("https://mobilem.liquifire.com")||srcurl.startsWith("https://mmllc")) {
								
									//https://mobilem.liquifire.com
									//||srcurl.startsWith("https://mmllc-images.s3.amazonaws.com/")
									
									//System.out.println("Src image starts with domain :"+srcurl);
									
									as.assertTrue(true);
									//Reporter.log("Src image not start with other domain [%s]: "+srcurl);
									
								}else {
									as.assertTrue(false);
									
									System.out.println("Src image not starts with domain :"+srcurl);
									Reporter.log("Src image start with other domain [%s]: "+srcurl);
								}
							
					}
					
				}
				}
				as.assertAll();
			
			
		}catch(Exception e) {
			
		}
	}

}
