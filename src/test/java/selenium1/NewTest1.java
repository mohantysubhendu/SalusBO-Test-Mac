package selenium1;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
//import au.com.bytecode.opencsv.CSVReader;



public class NewTest1 {

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
  
  // to test login with different combination of username and password
  
  @Test
  public void loginUsingWrongCredentials() throws InterruptedException, FileNotFoundException, IOException
  {


		
		//Thread.sleep(2000);

		 String baseUrl="https://admin-dev.salusconnect.io";
		
		 java.io.File file= new java.io.File("config.properties");
		 Properties prop = new Properties();
		 prop.load(new FileInputStream(file));
		 ArrayList<String> ls1 = new ArrayList<String>();
		 ls1.add(prop.getProperty("salus.us1"));
		 ls1.add(prop.getProperty("salus.pas1"));
		 ls1.add(prop.getProperty("salus.us2"));
		 ls1.add(prop.getProperty("salus.pas2"));
		 ls1.add(prop.getProperty("salus.us3"));
		 ls1.add(prop.getProperty("salus.pas3"));
		 //driver.findElement(By.className("pointer ng-scope")).click();
		 
		 
	     driver.get(baseUrl);
	     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys(ls1.get(2));
		 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys(ls1.get(3));
		 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();
		 Thread.sleep(5000);
		 String url1=driver.getCurrentUrl();
		 Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/login");
		 System.out.println("tried login with wrong password and  it couldn't signin");
		 
		 driver.get(baseUrl);
	     driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys(ls1.get(4));
		 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys(ls1.get(5));
		 driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();
		 Thread.sleep(5000);
		 String url2=driver.getCurrentUrl();
		 Assert.assertEquals(url2,"https://admin-dev.salusconnect.io/#/login");
		 System.out.println("tried login with wrong username and it couldn't signin");
  }
  

  //to verify the emailid
  
  @Test
  public void verifyEmailId() throws InterruptedException
  {
		String baseUrl="https://admin-dev.salusconnect.io";
		driver.get(baseUrl);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("subhenduhere@gmail.com");
		WebElement element=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/span[2]"));
		Thread.sleep(5000);
		/*String text=element.getText();
		String expectedText="";*/
		/*System.out.println(text);*/
		System.out.println("in verify userName");
		boolean b=false;
		if(element.isDisplayed())
		{
		System.out.println("Image displayed");
		b=true;
		}
		else{
		System.out.println("Image notdisplayed");
		
		}
		//System.out.println(b);
		Assert.assertEquals(b,true);
		 String url1=driver.getCurrentUrl();
		 Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/login");
		 System.out.println("tried login with wrong password and  it couldn't signin");
		//loginUsingWrongCredentials();
	
  }
  
 
  

}
