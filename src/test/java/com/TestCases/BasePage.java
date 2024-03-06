package com.TestCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.Utility.ExcelUtils;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class BasePage {

		static public WebDriver driver;
		//public WebDriver driver;// parallel testing
		public Properties p;
		static Logger logger;
		
		
		@BeforeTest
		public WebDriver setup() throws IOException
		
		{
			//loading properties file
			 FileReader file=new FileReader(".//src//test//resources//config.properties");
			 p=new Properties();
			 p.load(file);

			//loading log4j 
			logger=LogManager.getLogger(this.getClass());//Log4j
			
			if(p.getProperty("browser").equalsIgnoreCase("chrome"))
				driver=new ChromeDriver();
			else if(p.getProperty("browser").equalsIgnoreCase("edge"))
				driver=new EdgeDriver();
			else
				System.out.println("Invalid browser name");
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.get(p.getProperty("appURL"));
			driver.manage().window().maximize();
			return driver;
		}
		
		@DataProvider(name="testData")
	    public Object[][] testData() throws Exception{

	         Object[][] testObjArray = ExcelUtils.getTableArray("C:\\Users\\2303708\\eclipse-workspace\\HackathonProject\\testData\\TestData.xlsx","Sheet1");

	         return (testObjArray);

			}
		
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
		
		public static Logger getLogger() 
		{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
		}
		
		
		public static String captureScreen(String tname) throws IOException {

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\Screenshot\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}
	}

