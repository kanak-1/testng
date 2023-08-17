package testngscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SamoleOneTest {
  @Test
  public void searchCypressTest() {
	  WebDriver driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		//WebElement srcBox=driver.findElement(By.id("APjFqb"));
		//WebElement srcBox=driver.findElement(By.name("q"));
		//WebElement srcBox=driver.findElement(By.tagName("textarea"));
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Cypress Tutorial");  
		srcBox.sendKeys((Keys.ENTER));
		System.out.println("Page Title-" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cypresss Tutorial - Google Search");
	driver.close();
  }
}
