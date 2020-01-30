package com.velocity.qa.testcases;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.velocity.qa.base.TestBase;
import com.velocity.qa.pages.SearchMmdevOnPages;

public class GetAllUrls extends TestBase{
	
		public GetAllUrls(){
		super();
	}
	
	@BeforeTest
	public void setUp() {
		
		initialization();
    
	}
	
	@Test(priority=0)
	public void getUrlinExcel() throws InterruptedException {
		
		//create blank workbook
		  XSSFWorkbook workbook = new XSSFWorkbook();
		  //Create a blank sheet
		  XSSFSheet sheet = workbook.createSheet("Urls");
		  
		//Iterate over data and write to sheet
		  int rownum = 0;
		  int cellnum = 0;
		
		
		try {
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			//driver.get(prop.getProperty("url"));
			
			java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
			
			 for (int k=1; k<links.size();k++)
				 
			 {
				 String tagaurl=links.get(k).getAttribute("href");
				 							
				 addallaTagUrl.add(tagaurl);
				 
				 	 for(String name :  addallaTagUrl){
			            if(!newList.contains(name)){
			                newList.add(name);
			            }
			        }
				 
				
			 }
			 
			
			 
			 for(int i=0;i<newList.size();i++) {
				 
				
				 
				 if(newList.get(i).startsWith("https://")) {
				 driver.get(newList.get(i));
				// Thread.sleep(2000);
				System.out.println("Url Launched : "+newList.get(i));
				
				  Row row = sheet.createRow(rownum++);
					
					 Cell cell = row.createCell(cellnum);
					 cell.setCellValue(newList.get(i));
			
				 
				 }
				 }
			 
		}catch(Exception e) {
			e.printStackTrace();
			
		}
			// }
		
		
		try
		  {
		   //Write the workbook in file system
		   FileOutputStream out = new FileOutputStream(new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx"));
		   workbook.write(out);
		   out.close();
		   System.out.println("Urls.xlsx has been created successfully");
		  } 
		  catch (Exception e) 
		  {
		   e.printStackTrace();
		  }
		  finally {
		   try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
		
	}
		
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
	}

}
