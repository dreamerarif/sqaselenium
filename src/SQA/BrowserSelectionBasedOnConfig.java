package SQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelectionBasedOnConfig {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instantiating a Property Class
		Properties prop = new Properties();
		
		// Reading the Property file
		try {
			// Reading file stream from the specified file
			FileInputStream file = new FileInputStream("src\\config.properties");
			// Loading the file stream into the prop object
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Fetching the property value for browser
		String browser = prop.getProperty("browser");
		
		// Condition to run the browser
		if(browser.equals("chrome")) {
			// Setting Chrome Driver Property
			System.setProperty("webdriver.chrome.driver", "binaries\\chromedriver.exe");
			// Instatiate the ChromeDriver
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			// Setting Gecko Driver Property
			System.setProperty("webdriver.gecko.driver", "binaries\\geckodriver.exe");
			// Instantiate Firefox Driver
			driver = new FirefoxDriver();
		}
		
		// Maximizing the Browser window
		driver.manage().window().maximize();
		
		// Get the value of baseURL
		String url = prop.getProperty("baseURL");
		
		// Opening Google Homepage in Chrome Browser
		driver.get(url);
		
		// Sending search string to Google Search field
		WebElement googleSearchField = driver.findElement(By.name("q"));
		googleSearchField.sendKeys("Software Quality Assurance");
		
		// Click on Enter button
		googleSearchField.sendKeys(Keys.ENTER);
		
		// Quitting the driver
		//driver.quit();

	}

}
