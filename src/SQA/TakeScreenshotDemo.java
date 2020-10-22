package SQA;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakeScreenshotDemo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String browser = PropertyManager.getInstance().getBrowser();
		// Get the base URL from property config 
		String baseUrl = PropertyManager.getInstance().getBaseUrl();
		
		// Create the WebDriver based on the browser name from config
		if(browser.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "binaries\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "binaries\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Open the baseURL
		driver.get(baseUrl);
		
		// Maximizing the window
		driver.manage().window().maximize();
		
		// Locating the Search Field
		WebElement googleSearch = driver.findElement(By.name("q"));
		// Send the Search Query and send value of ENTER key
		googleSearch.sendKeys("Software Quality"+Keys.ENTER);
		
		Thread.sleep(5000);
		
		ScreenShotManager sc = new ScreenShotManager();
		sc.takeScreenShot(driver, "demo.png");
		
		
	}

}
