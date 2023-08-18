package parallelScripts;

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
		long id= Thread.currentThread().getId();
		System.out.println("This test is running" + id);
		System.out.println("Page Title-" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
	driver.close();
  }
}
