package parallelScripts;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;
import lombok.experimental.UtilityClass;

public class googlepagetest {
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extentReports= new ExtentReports();
		spark= new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}
	
 @Test
   public void searchJavaTest() {
	//  ChromeOptions options=new ChromeOptions();
	//	options.addArguments("--remote-allow-origins=*");
	//	 WebDriver driver=new ChromeDriver(options);
	 extentTest= extentReports.createTest("search java test" );
	   driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		//WebElement srcBox=driver.findElement(By.id("APjFqb"));
		//WebElement srcBox=driver.findElement(By.name("q"));
		//WebElement srcBox=driver.findElement(By.tagName("textarea"));
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("Java Tutorial");  
		long id= Thread.currentThread().getId();
		System.out.println("This test is running" + id);
		srcBox.sendKeys((Keys.ENTER));
		System.out.println("Page Title-" + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	driver.close();
	  
  }
 //@Test (invocationCount = 6, threadPoolSize =3, timeOut=2000)//for running multiple times
 @Test
 public void searchJavaTestOne() {
	//  ChromeOptions options=new ChromeOptions();
	//	options.addArguments("--remote-allow-origins=*");
	//	 WebDriver driver=new ChromeDriver(options);
	extentTest= extentReports.createTest("search selenium test" );
	  
	   driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");		
		driver.navigate().to("https://www.google.com/");
		//WebElement srcBox=driver.findElement(By.id("APjFqb"));
		//WebElement srcBox=driver.findElement(By.name("q"));
		//WebElement srcBox=driver.findElement(By.tagName("textarea"));
		WebElement srcBox=driver.findElement(By.className("gLFyf"));
		srcBox.sendKeys("selenium Tutorial");  
		long id= Thread.currentThread().getId();
		System.out.println("This test is running" + id);
		srcBox.sendKeys((Keys.ENTER));
		System.out.println("Page Title-" + driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "selenium Tutorial - Google Search");
		Assert.assertEquals(driver.getTitle(), "selenium Tutorial - Google Search Page"); //for test fail
	driver.close();
	 //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
	
 }
 @AfterMethod
 public void tearDown(ITestResult result) {
	if(ITestResult.FAILURE==result.getStatus()) {
		//extentTest.fail(result.getThrowable().getMessage());
		
		extentTest.fail(result.getThrowable().getMessage());
		String path=Utility.getScreenshotPath(driver);
		extentTest.addScreenCaptureFromPath(path);
		
	}
 }
 @AfterTest
 public void finishExtent()
 {
	 extentReports.flush(); //for creating rports
	 
 }
 
}
