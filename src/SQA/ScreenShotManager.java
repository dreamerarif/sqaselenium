package SQA;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotManager {
	
	public void takeScreenShot(WebDriver driver, String filename)
	{
		// Converting the WebDriver object to Screenshot object
		TakesScreenshot scr = ((TakesScreenshot)driver);
		
		// Taking the screenshot as a File
		File src = scr.getScreenshotAs(OutputType.FILE);
		if(filename.isEmpty()) {
			filename = "Screenshot_" + Math.random()+".jpg";
		}
		// Creating a destination
		File destFile = new File("screenshots\\"+filename);
		
		// Copying the screenshot to the destination file
		
		try {
			FileUtils.copyFile(src, destFile);
		} catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}
