package testngscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CRMLogin {
	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException {
		String path=System.getProperty("user.dir")
				+"//src//test//resources//configFiles//configCRM.properties";
		prop=new Properties();
		FileInputStream fin=new FileInputStream(path);
		prop.load(fin);
		String strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
	}
	@Test
	
	public void ValidLogin() {
		driver.get(prop.getProperty("url"));
		driver.findElement(By.name("email")).sendKeys("kanakgupta9515@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Kanak@crm15");
		driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
		boolean isDisp=driver.findElement(By.xpath("//span[@class='user-display']")).isDisplayed();
		Assert.assertTrue(isDisp);
	}
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	

}
