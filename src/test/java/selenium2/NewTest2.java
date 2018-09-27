package selenium2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest2 {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	 // System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
	  System.setProperty("webdriver.chrome.driver","/Users/Shared/Jenkins/Home/chromedriver");
		 driver = new ChromeDriver();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

//to verify dashboard is coming or not
  
 @Test  
 public void Dashboard() throws InterruptedException {
	    driver.get("https://admin-dev.salusconnect.io/#/login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("rameshamr831+25@gmail.com");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ab123456");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();
		Thread.sleep(10000);
		String urlText = driver.getCurrentUrl();
		Thread.sleep(2000);
		
	    Assert.assertEquals(urlText, "https://admin-dev.salusconnect.io/#/deviceManagement/dashboard" );
	    System.out.println("We are on dashboard");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[2]/a")).click();
		Thread.sleep(2000);
		String urlText1 = driver.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertEquals(urlText1, "https://admin-dev.salusconnect.io/#/deviceManagement/deviceListOverview" );
	    System.out.println("Device element is present");
	    Thread.sleep(2000);
	    
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
    	String urlText2 = driver.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertEquals(urlText2, "https://admin-dev.salusconnect.io/#/deviceManagement/rules/" );
	    System.out.println("Rule element is present");
	    Thread.sleep(2000);
	    
	   

	    driver.findElement(By.xpath(" /html/body/div[1]/header/div/ul/li[4]/a")).click();
		Thread.sleep(2000);
		String urlText3 = driver.getCurrentUrl();
		Thread.sleep(2000);
		Assert.assertEquals(urlText3, "https://admin-dev.salusconnect.io/#/deviceManagement/bookings" );
	    System.out.println("Bookings element is present");
	    Thread.sleep(2000);
	    
	    
	    driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[7]/a")).click();
		
		
		
}
  
  
}
