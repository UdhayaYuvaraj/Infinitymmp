package infinitymmp;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenMRM_PatientRegister {

	
	WebDriver driver;
	
	
	@BeforeMethod
	public void Setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}
	@Test
	public void LoginPage()
	{
		
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register a patient']")).click();
		Random rand=new Random();
		int num=rand.nextInt(100);
	    driver.findElement(By.xpath("//input[@name='givenName']")).sendKeys("Udhaya"+num+"");
	    int num1=rand.nextInt(120);
	    driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Yuvaraj"+num1+"");
	    int num3=rand.nextInt(70);
	    driver.findElement(By.xpath("//input[@name='familyName']")).sendKeys("UdayYuva"+num3+"");
	    driver.findElement(By.xpath("//input[@id='checkbox-unknown-patient']")).click();
	    Select dropdown=new Select(driver.findElement(By.id("gender-field")));
	    dropdown.selectByVisibleText("Female");
	    driver.findElement(By.xpath("//button[@id='next-button']")).click();
        driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
	}
	
}