package testngscripts;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
	WebDriver driver;
	Properties prop; //created properties object
	@BeforeMethod	
	public void setup() throws IOException {
		String path=System.getProperty("user.dir")
				+"//src//test//resources//configFiles//config.properties";
		prop=new Properties();
		FileInputStream fin=new FileInputStream(path);
		prop.load(fin);
		String strBrowser=prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
			
	}
	@Test(dataProvider = "loginData") //dataProvider is used to fetch data from DataProvider method (is providing the data)
	
	   public void loginTest(String strUser,String strPwd) {
		driver.get(prop.getProperty("url"));
		//driver.get("https://the-internet.herokuapp.com/login");
		
				//USING xpath
				
				//driver.findElement(By.xpath("//input[@id='username' and @type='text']")).sendKeys("tomsmith");
				//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//input[@id='username' and @type='text']")).sendKeys(strUser); //reading username & pwd from csv file
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(strPwd);
				//driver.findElement(By.xpath("//button[@class='radius']")).click();
				//driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click(); //used for compound class9having more than 1 class0
				driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in")).click();
				boolean isDisp=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
				Assert.assertTrue(isDisp);
		
	}
	//Users [][]
	//user1 - uname,pwd
	//user2 - uname,pwd
	//user3 - uname,pwd
	
	@DataProvider(name="loginData") //method to provide data from external source(such as CSV)
	public Object[][] getData() throws CsvValidationException, IOException {
		String path=System.getProperty("user.dir")
				+"//src//test//resources//testData//loginData.csv";
		
		CSVReader reader=new CSVReader(new FileReader(path));
		String arr[];
		ArrayList<Object> dataList= new ArrayList<Object>(); // arraylist as array is static method (we need to declare size of array in array method
		while((arr=reader.readNext()) != null) {
			Object[] record= {arr[0],arr[1]}; //arrays are static so we will create an arrayList
			dataList.add(record);
			
		}
		
		return dataList.toArray(new Object[dataList.size()][]); //converting arrayList into array
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
