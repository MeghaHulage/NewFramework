package com.velocity.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.velocity.qa.base.TestBase;

public class HttpStatusPages extends TestBase {
	
  
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	XSSFWorkbook wk;
	XSSFSheet sh;
	
	public HttpStatusPages() {
		PageFactory.initElements(driver, this);
	}

	
	public void checkUrlStatus() throws IOException {
		try {
		
		SoftAssert as= new SoftAssert();
		File fp=new File("./src/main/java/com/velocity/qa/testdata/Urls.xlsx");
		FileInputStream fs= new FileInputStream(fp);
		XSSFWorkbook wk= new XSSFWorkbook(fs);
		XSSFSheet sh= wk.getSheetAt(0);
			
			for(int i=0;i<sh.getLastRowNum();i++) {
				
				for(int j=0;j<sh.getRow(i+1).getLastCellNum();j++) {
						
						String linkurl=sh.getRow(i+1).getCell(0).getStringCellValue();
					
						
						  try{
							  
							  URL url=new URL(linkurl);
							  HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
							  Thread.sleep(3000);

							  httpURLConnect.setConnectTimeout(3000);
							  httpURLConnect.connect();
							  if(httpURLConnect.getResponseCode()==200){
								  as.assertFalse(false);
								 // Reporter.log("Url is "+linkurl +"- status is "+httpURLConnect.getResponseMessage());
								 
							 // System.out.println(linkurl+"-"+httpURLConnect.getResponseMessage());
							 

							  }
							  if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
								  as.assertFalse(true);
								  Reporter.log("Url is [%s]"+linkurl +"- status is [%s]"+httpURLConnect.getResponseMessage());
							  System.out.println(linkurl +"-"+httpURLConnect.getResponseMessage());
							  }
							  }catch(Exception e){
							  System.out.println("Exception:"+e);
							  }
					  
				  }
					
					
				
				
			}
			//as.assertAll();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
