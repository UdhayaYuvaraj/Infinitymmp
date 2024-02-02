package infinitymmp;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Rediff_GainerStock {
	
	

	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://money.rediff.com/gainers");
	}
	@Test
	public void reddifstock()
	{
		///stockname
		String StockName="Patron Exim";
		//currentprice
		String CurrentPrice=driver.findElement(By.xpath("//a[normalize-space()='"+StockName+"']/parent::td/following-sibling::td[3]")).getText();
		//previous close
		String PreviousClose=driver.findElement(By.xpath("//a[normalize-space()='"+StockName+"']/parent::td/following-sibling::td[2]")).getText();
		//change
		String change=driver.findElement(By.xpath("//a[normalize-space()='"+StockName+"']/parent::td/following-sibling::td[4]")).getText();
		//get value
		System.out.println(StockName+" of CurrentPrice:"+CurrentPrice+",PreviousClose:"+PreviousClose);
		//checkthechange
		Double actual_change=Double.parseDouble(change.replace("+",""));
		System.out.println("Percentage change:"+actual_change);
		Double change_percentage=(Double.parseDouble(CurrentPrice)-Double.parseDouble(PreviousClose))/Double.parseDouble(PreviousClose)*100 ;
		String change_value=String.format("%.2f",change_percentage);
		Double Expected_change=Double.parseDouble(change_value);
		System.out.println("Checking the Percentage of "+StockName+":"+Expected_change);
		Assert.assertEquals(actual_change,Expected_change);
	
	}
    @AfterMethod
	public void teartown() throws Exception
	{
		driver.quit();
		Thread.sleep(2000);
	}
}
