package org.iit.healthcare.patientmodule.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.iit.healthcare.infinitymmp.AppLibrary;
import org.iit.healthcare.infinitymmp.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ScheduleAppointmentDatePicker_Tests extends BaseClass{

	
	//JSON : java script object notation
		@Parameters({"username","password"})
		@Test
		public void scheduleAppointmentTest(String username,String password)
		{
		 
			
		    MMPLib mmpLib = new MMPLib(driver);
		    mmpLib.launchBrowser(mmpProp.getProperty("patienturl"));
		    String actual = mmpLib.login(username, password);
			String expected=mmpProp.getProperty("patientusername");
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(actual,expected);
			
			HashMap<String,String> expectedHMap = bookAppoinment(40);
			HashMap<String,String> actualHMap = fetchPatientData();
			System.out.println(expectedHMap);
			System.out.println(actualHMap);
			
			sa.assertEquals(actualHMap,expectedHMap);
			
			sa.assertAll();
		}
		 
		public HashMap<String, String> bookAppointment()
		{
			HashMap<String,String> expectedHMap = new HashMap<String,String>();
			driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
			driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
			
			String doctorName="Smith";
			String description="Orthopedic";
			expectedHMap.put("doctor", doctorName);
			driver.findElement(By.xpath("//h4[text()='Dr."+doctorName+"']/parent::li/div/p[text()='Description:"+description+"']/ancestor::ul/following-sibling::button")).click();
		
			driver.switchTo().frame("myframe");
			driver.findElement(By.id("datepicker")).click();
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			
			Random rand = new Random();
			String randomDate = rand.nextInt(29)+"";
			driver.findElement(By.linkText(randomDate)).click();
			expectedHMap.put("date",driver.findElement(By.id("datepicker")).getAttribute("value"));
			
			Select timeSelect = new Select(driver.findElement(By.id("time")));
			String appointmentTime="11Am";
			timeSelect.selectByVisibleText(appointmentTime);
			expectedHMap.put("time", appointmentTime);
			
			
			
			driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
			driver.switchTo().defaultContent();
			
			String symp="fever & flu";
			expectedHMap.put("appointment", symp);
			driver.findElement(By.id("sym")).sendKeys(symp);
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			System.out.println("Expected HMAP" + expectedHMap);
			
			return expectedHMap;
			
		}
		
		public HashMap<String,String> bookAppoinment(int noofDays)
		{
			HashMap<String,String> expectedHMap = new HashMap<String,String>();
			driver.findElement(By.xpath("//span[normalize-space()='Schedule Appointment']")).click();
			driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
			
			String doctorName="Smith";
			String description="Orthopedic";
			expectedHMap.put("doctor", doctorName);
			driver.findElement(By.xpath("//h4[text()='Dr."+doctorName+"']/parent::li/div/p[text()='Description:"+description+"']/ancestor::ul/following-sibling::button")).click();
		
			driver.switchTo().frame("myframe");
			driver.findElement(By.id("datepicker")).click();
			 
			String futureDate = AppLibrary.getFutureDate(noofDays);
			String dateArr[] = futureDate.split("/");
			System.out.println(dateArr[0]);
			System.out.println(dateArr[1]);
			System.out.println(dateArr[2]);
			
			String expectedYear = dateArr[2];//2025
			String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//2025
			
			while(!(actualYear.equals(expectedYear)))
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			}
			String expectedMonth = dateArr[1];//April
			String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//January
			
			while(!(actualMonth.equals(expectedMonth)))
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			}
			
			driver.findElement(By.linkText(dateArr[0])).click();
			expectedHMap.put("date",driver.findElement(By.id("datepicker")).getAttribute("value"));
			
			
			Select timeSelect = new Select(driver.findElement(By.id("time")));
			String appointmentTime="11Am";
			timeSelect.selectByVisibleText(appointmentTime);
			expectedHMap.put("time", appointmentTime);
			
		//	Duration d = new Duration(30);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("status")));
			
			
			driver.findElement(By.xpath("//button[@id='ChangeHeatName']")).click();
			driver.switchTo().defaultContent();
			
			String symp="fever & flu";
			expectedHMap.put("appointment", symp);
			driver.findElement(By.id("sym")).sendKeys(symp);
			driver.findElement(By.xpath("//input[@value='Submit']")).click();
			System.out.println("Expected HMAP" + expectedHMap);
			
			return expectedHMap;
		}
		
		public HashMap<String,String> fetchPatientData(){
			
			HashMap<String,String> actualHMap = new HashMap<String,String>();
			actualHMap.put("doctor", driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText().trim());
			actualHMap.put("appointment", driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText().trim());
			actualHMap.put("time", driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().trim());
			actualHMap.put("date", driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText().trim());
			return actualHMap;
			
		}
		 
	}