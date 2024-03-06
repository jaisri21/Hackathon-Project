package com.stepDefinition;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Factory.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	 Properties p;
    
	@Before
   public void setup() throws IOException, InterruptedException
   {
   	driver=BaseClass.initilizeBrowser();
   	    	
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	//driver.get("https://www.urbanladder.com/");
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   	driver.manage().window().maximize();
   
   			
	}
		
   
   @After
   public void tearDown(Scenario scenario) {
       		
      driver.quit();
      
   }
   

   @AfterStep
   public void addScreenshot(Scenario scenario) {
       
   	// this is for cucumber junit report
        if(scenario.isFailed()) {
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());
        }	   
     
   }
}
