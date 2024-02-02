package org.iit.healthcare.patientmodule.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibr {
	
	//this construct create another package too
	WebDriver driver;
	public MMPLibr(WebDriver driver) {
		this.driver=driver;
	}

	
	public String login(String username,String password)
	{

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		String actual=driver.findElement(By.xpath("//h3[normalize-space()='ria1']")).getText();
		return actual;
	}
public void navigateToModule(String moduleName)
{
	driver.findElement(By.xpath("//span[normalize-space()='+moduleName+']")).click();
}
public void launchBrowser(String url)
{
	driver.get(url);
}



	
}
