package org.iit.healthcare.patientmodule.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;

import org.iit.healthcare.infinitymmp.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ScheduleAppointmentTests extends BaseClass {

	@Test
	public void bookAppoinment() 
	{
		HashMap<String,String> expectedHMap=new HashMap<String,String>();
		//HashMap<String,String> actualHMap=new HashMap<String,String>();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(mmpProp.getProperty("patienturl"));
		driver.findElement(By.id("username")).sendKeys(mmpProp.getProperty("patientusername"));
		driver.findElement(By.id("password")).sendKeys(mmpProp.getProperty("patientpassword"));
		driver.findElement(By.name("submit")).click();
		String actual=driver.findElement(By.xpath("//h3[normalize-space()='ria1']")).getText();
        String Expected="ria1";
        Assert.assertEquals(actual,Expected);
        
        driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
        driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
        String doctorname="Smith";
        String decription="Orthopedic";
        expectedHMap.put("doctorName", doctorname);    
        
        driver.findElement(By.xpath("//h4[text()='Dr."+doctorname+"']/following-sibling::div/p[contains(text(),'"+decription+"')]/ancestor::ul/following-sibling::button")).click();
      
        WebElement iframe = driver.findElement(By.id("myframe"));
        driver.switchTo().frame(iframe);

        // Interact with the datepicker inside the iframe
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        Random rand=new Random();
        String randomdate=65+rand.nextInt(28)+"";
        System.out.println(randomdate);
        
        driver.findElement(By.linkText(randomdate)).click();
        expectedHMap.put("Appoinment",driver.findElement(By.id("datepicker")).getAttribute("value"));
        
        
        Select dropdown=new Select(driver.findElement(By.id("time")));
        String appoinmentTime="11Am";
        dropdown.selectByVisibleText(appoinmentTime);  
        expectedHMap.put("time", appoinmentTime);
        
        driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();  
        //here its not compilsory because its going to next page
        driver.switchTo().defaultContent();
     
        String symp="Fever&cold";
        expectedHMap.put("appoinment",symp);
        driver.findElement(By.id("sym")).sendKeys(symp);
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println("Expected HMap:"+expectedHMap);
	}
	
	
	 
	
}
