package testngscripts;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class googlepagetest {
 @Test
   public void searchJavaTest() {
	//  ChromeOptions options=new ChromeOptions();
	//	options.addArguments("--remote-allow-origins=*");
	//	 WebDriver driver=new ChromeDriver(options);
	  
	  WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		//WebElement srcBox=driver.findElement(By.id("APjFqb"));
		//WebElement srcBox=driver.findElement(By.name("q"));
		//WebElement srcBox=driver.findElement(By.tagName("textarea"));
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");  
		srcBox.sendKeys((Keys.ENTER));
		System.out.println("Page Title-" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	driver.close();
	  
  }
 @Test
 public void searchJavaTestOne() {
	//  ChromeOptions options=new ChromeOptions();
	//	options.addArguments("--remote-allow-origins=*");
	//	 WebDriver driver=new ChromeDriver(options);
	  
	  WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		//WebElement srcBox=driver.findElement(By.id("APjFqb"));
		//WebElement srcBox=driver.findElement(By.name("q"));
		//WebElement srcBox=driver.findElement(By.tagName("textarea"));
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("selenium Tutorial");  
		srcBox.sendKeys((Keys.ENTER));
		System.out.println("Page Title-" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "selenium Tutorial - Google Search");
	driver.close();
 }
}
