package SQA;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptExecutor {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Get the browser name from property config
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
		
		// String Array of URLs
		String[] urls = {"https://www.google.com", "https://www.yahoo.com",
						"https://www.twitter.com", "https://www.instagram.com",
						"https://www.facebook.com"};
		// Converting WebDriver object into JavascriptExecutor Object
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		
		// Opening Multiple Tabs
		for(int i=0; i<urls.length; i++)
		{
			js.executeScript("window.open('"+urls[i]+"')");
			Thread.sleep(2000);
		}
		//js.executeScript("alert('Hello SQA!!')");
		
		// Get the Tab IDs
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		
		//System.out.print(tabs);
		System.exit(0);
		
		Thread.sleep(5000);
		
		// Navigating to the Tab having index 2
		driver.switchTo().window(tabs.get(5));
		
		// Verify the title of Google and close the tab
		if(driver.getTitle().equals("Google"))
		{
			// Locating the Search Field
			WebElement googleSearch = driver.findElement(By.name("q"));
			// Send the Search Query and send value of ENTER key
			googleSearch.sendKeys("Software Quality"+Keys.ENTER);
		}
		Thread.sleep(5000);
		
		js.executeScript("window.close()");
		
		Thread.sleep(5000);
		
		// Navigating to the Tab having index 2
		driver.switchTo().window(tabs.get(1));
	
		//js.executeScript("window.close()");
		
		//driver.quit();
	}
}
