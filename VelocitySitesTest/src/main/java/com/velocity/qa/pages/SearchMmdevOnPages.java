package com.velocity.qa.pages;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.util.TestUtil;

public class SearchMmdevOnPages extends TestBase {
	
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	
	
	public SearchMmdevOnPages() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void serachMmDev() {
		try {
			
			
			SoftAssert As= new SoftAssert();
			File fp=new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx");
			FileInputStream fs= new FileInputStream(fp);
			XSSFWorkbook wk= new XSSFWorkbook(fs);
			XSSFSheet sh= wk.getSheetAt(0);
			
		for(int i=0;i<sh.getLastRowNum();i++) {
			
			for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
					
					String siteurl=sh.getRow(i+1).getCell(0).getStringCellValue();
					//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
					//driver.get(siteurl);
					Boolean mmdev=driver.getPageSource().contains(".mm-dev.agency");
					
					if(mmdev) {
						
						
						As.assertFalse(mmdev);
					//System.out.println("mm-dev.agency on URL  "+ siteurl);
					Reporter.log("mm-dev.agency on URL [%s]"+siteurl);
					}else {
						
						As.assertFalse(mmdev);
						
					}
					
					
					
					
			}
		}
		
		As.assertAll();
		
	}catch(Exception e) {
		 e.printStackTrace();
		 
	 }
		
		
	}
	

}
