package commonUtils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static String getScreenshotPath(WebDriver driver) {
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		String srcFile=System.getProperty("user.dir")
				+"/screenshot/"
				+System.currentTimeMillis()
				+".png";
		File dest=new File(srcFile);
		try {
			FileUtils.copyFile(src, dest);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return srcFile;
		
	}

}
