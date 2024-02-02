package org.iit.healthcare.patientmodule.tests;
import java.util.Random;

import org.iit.healthcare.infinitymmp.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfileTests extends BaseClass {
	//WebDriver driver;
	MMPLib mmpLib;
	@BeforeClass
	public void initialize_Driver()
	{
		 // WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			mmpLib=new MMPLib(driver);
	}
	
	@Test
	public void ValidateEditProfileTests()
	
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		mmpLib.login();
        boolean result=editFirstName();
        SoftAssert sa1=new SoftAssert();
        sa1.assertTrue(result);
        boolean result1=editLastName();
        sa1.assertTrue(result1);
        boolean result2=editLicence();
        sa1.assertTrue(result2);
        sa1.assertAll();
       
	}
	@Test
	public void validate_withInvalidData()
	{
		
		mmpLib.login();
        boolean FName_result=EditFirstName_withInvalidData();
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(FName_result);
        boolean LName_result=EditLastName_withInvalidData();
        sa.assertTrue(LName_result);
        boolean Licence_result=EditLicence_withInvalidData();
        sa.assertTrue(Licence_result);
        boolean Licence_result1=EditLicence_withInvalidAlbtData();
        sa.assertTrue(Licence_result1);
        sa.assertAll();
	}
	public boolean EditFirstName_withInvalidData()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(generateRandomNumber());
	    driver.findElement(By.id("Sbtn")).click();
	    String actual=driver.findElement(By.id("firsterr1")).getText().trim();
	    String Expected="please enter only alphabets";
	    return Expected.equals(actual);
	}
    public boolean editFirstName()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("fname")).clear();
		String expectedfNameValue="FNAMEAUTIcs"+generateRandomString();
		driver.findElement(By.id("fname")).sendKeys(expectedfNameValue);
		driver.findElement(By.id("Sbtn")).click();
		Alert altr=driver.switchTo().alert();
		altr.accept();
		String actualfNameValue=driver.findElement(By.id("fname")).getAttribute("value");
		return expectedfNameValue.equals(actualfNameValue);
		
	}
    public boolean EditLastName_withInvalidData()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("lname")).clear();
		driver.findElement(By.id("lname")).sendKeys(generateRandomNumber());
	    driver.findElement(By.id("Sbtn")).click();
	    String actual=driver.findElement(By.id("lasterr1")).getText().trim();
	    String Expected="please enter only alphabets";
	    return Expected.equals(actual);
	}

  
    public boolean editLastName()
	{
		//driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
		driver.findElement(By.id("Ebtn")).click();
		driver.findElement(By.id("lname")).clear();
		String expectedlNameValue="AutomationSeleniumJi"+generateRandomString();
		driver.findElement(By.id("lname")).sendKeys(expectedlNameValue);
		driver.findElement(By.id("Sbtn")).click();
		Alert altr=driver.switchTo().alert();
		altr.accept();
		String actuallNameValue=driver.findElement(By.id("lname")).getAttribute("value");
		return expectedlNameValue.equals(actuallNameValue);
		
	}
    public boolean EditLicence_withInvalidData()
   	{
    	driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
   		driver.findElement(By.id("Ebtn")).click();
   		driver.findElement(By.id("licn")).clear();
   		driver.findElement(By.id("licn")).sendKeys(generateInvalid_LicenceNumber()+"");
   	    driver.findElement(By.id("Sbtn")).click();
   	    String actual=driver.findElement(By.id("licerr")).getText().trim();
   	    String Expected="Please enter valid 8-digit license number(Only digits)";
   	    return Expected.equals(actual);
   	}
    public boolean EditLicence_withInvalidAlbtData()
   	{
    	driver.findElement(By.xpath("//span[normalize-space()='Profile']")).click();
   		driver.findElement(By.id("Ebtn")).click();
   		driver.findElement(By.id("licn")).clear();
   		driver.findElement(By.id("licn")).sendKeys(generateInvalidAlbt_LicenceNumber());
   	    driver.findElement(By.id("Sbtn")).click();
   	    String actual=driver.findElement(By.id("licerr")).getText().trim();
   	    String Expected="Please enter valid 8-digit license number(Only digits)";
   	    return Expected.equals(actual);
   	}

    public boolean editLicence()
    {
    	driver.findElement(By.id("Ebtn")).click();
    	driver.findElement(By.id("licn")).clear();
    	String expectedlicenceValue=generateLicenceNumber()+"";
    			
    	driver.findElement(By.id("licn")).sendKeys(expectedlicenceValue);
    	driver.findElement(By.id("Sbtn")).click();
		Alert altr=driver.switchTo().alert();
		altr.accept();
		String actuallLicenceValue=driver.findElement(By.id("licn")).getAttribute("value");
		return expectedlicenceValue.equals(actuallLicenceValue);
		
    }
    
	public String generateRandomString()
	{
		Random rand=new Random();
		int u=65+rand.nextInt(26);
		char uppercase=(char) u;
		System.out.println("UpperCase:"+uppercase);
		
		
		//lowercase 97 to 122
		int l=97+rand.nextInt(122-97+1);
		char lowercase=(char)l;
		System.out.println("LowerCase:"+lowercase);
	
		
		String randomString=uppercase+""+lowercase+"";
		return randomString;
	
}
	public String generateRandomNumber()
{
	Random rand=new Random();
	int u=65+rand.nextInt(26);
	System.out.println("UpperCase:"+u);
	
	
	//lowercase 97 to 122
	int l=97+rand.nextInt(122-97+1);
	System.out.println("LowerCase:"+l);

	
	String randomnumber=u+l+"";
	return randomnumber;

}
	public int generateLicenceNumber()
	{
		Random rand=new Random();
		int num=12345678+rand.nextInt(26);
		System.out.println("LicenceNumber:"+num);
		int RandomLicenceNumber=num;
		return RandomLicenceNumber;
	}
	public int generateInvalid_LicenceNumber()
	{
		Random rand=new Random();
		int num=123456781+rand.nextInt(26);
		System.out.println("Invalid LicenceNumber:"+num);
	    int Invalid_RandomLicenceNumber=num;
		return Invalid_RandomLicenceNumber;
	}
	public String generateInvalidAlbt_LicenceNumber()
	{
		Random rand=new Random();
		int num=65+rand.nextInt(26);
		char i=(char)num;
		System.out.println("Invalid LicenceName:"+i);
	    String Invalid_RandomLicenceName=i+"";
		return Invalid_RandomLicenceName;
	}
	
	
}