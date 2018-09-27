package selenium3;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.thoughtworks.selenium.webdriven.commands.Click;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest3 {
 
  
  WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	   System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
	   //System.setProperty("webdriver.chrome.driver","/Users/Shared/Jenkins/Home/chromedriver");
	   driver = new ChromeDriver();
  }


  
  
/*	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.firefox.marionette", "/usr/bin/firefox");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
			//create chrome instance
			driver = new ChromeDriver();
		}
	}*/
  @AfterClass
  public void afterClass() {
	
		  driver.quit();
	  
  }
  
  // testing signin for Admin
  
  @Test(alwaysRun=true)
  public void loginOemAdmin() throws InterruptedException
  {
	 
	   String baseUrl="https://admin-dev.salusconnect.io";
	   driver.get(baseUrl);
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys("Anushree.somaiah@techchefs.in");
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys("Ab123456");
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();
	   Thread.sleep(10000);
	   String url1=driver.getCurrentUrl();
	   System.out.println(url1);
	   Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/deviceManagement/dashboard");
	   System.out.println("we are successfully signed in for OEMAdminUser");
  }
  
  @Test(alwaysRun=true)
  public void oemAdminCheckingAllModules() throws InterruptedException
  {
	  /*String baseUrl="https://admin-dev.salusconnect.io";
	   driver.get(baseUrl);
	   Thread.sleep(10000);*/
	   String urla=driver.getCurrentUrl();
	   System.out.println(urla);
	 WebElement name =driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[2]/a"));
	 /*boolean b=name.equals("Facility Management");
	 if(b==true)
		 System.out.println("Facility Management is present" );
	 else
	 System.out.println("Facility Management is not present ");
	 
	 */
	 
	 String name2 = name.getText();
	 
	 System.out.println(name2); 
	 
	 Assert.assertEquals(name2, "Facility Management");
	 System.out.println("Facility Management is present for OEMAdmin"); 
	 
	 Thread.sleep(2000);
	 WebElement name1=driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[2]/a"));
	 name1.equals("Dashboard");
	 System.out.println("Dashboard is present for OEMAdmin");
	 
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[5]/a")).click();
	 String url1=driver.getCurrentUrl();
	 Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/vendor/managevendor");
	 System.out.println("Vendor link present for OEMAdmin");
	// Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/admin/manageUsers");
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[2]/div/div[2]/a")).click();
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[2]/a")).click();
	 Thread.sleep(2000);
	 String url2=driver.getCurrentUrl();
	 Assert.assertEquals(url2,"https://admin-dev.salusconnect.io/#/deviceManagement/deviceListOverview");
	 System.out.println("Devices link present for OEMAdmin");
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[3]/a")).click();
	 String url3=driver.getCurrentUrl();
	 Assert.assertEquals(url3,"https://admin-dev.salusconnect.io/#/deviceManagement/rules/");
	 System.out.println("Rules link present for OEMAdmin");
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[4]/a")).click();
	 String url4=driver.getCurrentUrl();
	 Assert.assertEquals(url4,"https://admin-dev.salusconnect.io/#/deviceManagement/bookings");
	 System.out.println("Bookings link present for OEMAdmin");
	 
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("/html/body/div[1]/header/div/ul/li[5]/a")).click();
	 String url5=driver.getCurrentUrl();
	 Assert.assertEquals(url5,"https://admin-dev.salusconnect.io/#/deviceManagement/alerts");
	 System.out.println("Alerts link present for OEMAdmin");

  }
  
  
/*  @Test
  public void csvReader() throws IOException, InterruptedException
  {
	  CSVReader reader = new CSVReader(new FileReader("/home/subhendu/workspace/salus.backOffice/read.csv"));
	  //String [] nextLine;
	  //while ((nextLine = reader.readNext()) != null) {
	  //System.out.println(“Value 1 : [” + nextLine[0] + “]\nValue 2 : [” + nextLine[1] + “]\nValue 3 :[” + nextLine[2] + “]\nValue 4 :[” + nextLine[3] + “]”);
	  List<String[]> li=reader.readAll();
	  System.out.println("Total rows which we have is " + li.size());
	// create Iterator reference
	  Iterator<String[]>i1= li.iterator();
	    
	 // Iterate all values 
	 while(i1.hasNext()){
		 Thread.sleep(5000);
	   String[] str=i1.next();
	   String baseUrl="https://admin-dev.salusconnect.io";
	   driver.get(baseUrl);
	   
	 System.out.print(" Values are ");
	 
	 for(int i=0;i<str.length;i++)
	{
	 
	   System.out.println(str.length);
	   System.out.print(" "+str[i]);
	   
	   System.out.print(" "+str[i+1]);
	
	   Thread.sleep(5000);
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[1]/div/div[1]/input")).sendKeys(str[i]);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[2]/div/div[1]/input")).sendKeys(str[i+1]);
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/div[2]/div/form/div[4]/div/button")).click();
	   Thread.sleep(10000);
	   String url1=driver.getCurrentUrl();
	   System.out.println(url1);
	 //  Assert.assertEquals(url1,"https://admin-dev.salusconnect.io/#/login");
	  // System.out.println("successfully signed in");
	   i++;
	}
	   System.out.println("   ");
	     
	    
	}
	  
  }*/

}
