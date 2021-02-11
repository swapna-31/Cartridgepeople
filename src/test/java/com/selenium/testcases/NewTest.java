package com.selenium.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class NewTest {
	public static WebDriver driver;
	public static String browserName = "chrome";
	
  @Test
  public void f() {
	  
      driver.get("https://www.cartridgepeople.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }
  @BeforeTest
  public void beforeTest() {
	  
	  if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Driversnew\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("ie")) {
			// Zoom setting should be 100%
			// Security zones should be either enabled or disabled
			System.setProperty("webdriver.ie.driver",
					"C:\\BrowserDriver\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\BrowserDriver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver(); 
			}
  }

  
  @AfterTest
  public void afterTest() throws InterruptedException {
	  
	  WebElement menu = driver.findElement(By.xpath("//*[@id=\"shopmenu\"]/div[1]/ul/li[5] "));
	    
	    Actions actions=new Actions(driver);
	  actions.moveToElement(menu).perform();
	    driver.findElement(By.xpath("//*[@id=\"shopmenu\"]/div[2]/div[4]/div/ul/li[1]/a")).click();
	    
	    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	    driver.findElement(By.xpath("//*[@id=\"product-list-content\"]/ul/li[4]/div/div/div[1]/div[1]/h2/a")).click();
	    ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	    driver.findElement(By.xpath("//*[@id=\"product-lead\"]/div[2]/div/div/form/button")).click();
	  //*[@id="add-to-basket-prompt"]/div/div/div[3]/div[2]/a
	    driver.findElement(By.xpath("//*[@id=\"add-to-basket-prompt\"]/div/div/div[3]/div[2]/a")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"basket-checkout-links\"]/div/a[1]")).click();
	  
	    // for new customer code
	    
	   /* WebElement radiobtn =driver.findElement(By.id("registerRadio"));
	    radiobtn.click();
	    System.out.println(radiobtn.isSelected());
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//*[@id=\"registerLink\"]")).click();
	    driver.findElement(By.id("FullName")).sendKeys("Swapna");
	    driver.findElement(By.id("EmailAddress")).sendKeys("Cartridgepeople72@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("Cartridgepeople1!");
	    driver.findElement(By.name("button")).click();*/
	    
	    //for existing customer 
	    
	    WebElement radiobtn =driver.findElement(By.id("loginRadio"));
	    radiobtn.click();
	    System.out.println(radiobtn.isSelected());
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElement(By.id("emailAddress")).sendKeys("cartridgepeople72@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("Cartridgepeople1!");
	    driver.findElement(By.id("submit")).click();
	    
	  
	
	 //WebElement menu = driver.findElement(By.name("Address_TitleId "));
 WebElement element = driver.findElement(By.id("Address_TitleId"));
  List<WebElement> list = element.findElements(By.tagName("option"));
  
  System.out.println("list size="+list.size());
  for(int i=0;i<list.size();i++) {
	  System.out.println("print values="+list.get(i).getText());
	  if(list.get(i).getText().equals("Mr")) {
		  list.get(i).click();
		  break;
	  }
  }
  driver.findElement(By.id("Address_Postcode")).sendKeys("EH6 7EY");
  driver.findElement(By.id("Address_CustomerNameFull")).sendKeys("Laila");
  driver.findElement(By.id("Address_CompanyName")).sendKeys("XYZ LTD");
  driver.findElement(By.id("Address_StreetAddress")).sendKeys("2 Royal street");
  driver.findElement(By.id("Address_City")).sendKeys("London");
  driver.findElement(By.id("Address_Phone")).sendKeys("07123456789");
  driver.findElement(By.id("Next-Button")).click();
  
  
  }
}


	  
  
  

  
  
  

