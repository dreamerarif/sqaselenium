package SQA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
	private static String baseUrl;
	private static String browser;
	private static PropertyManager instance;
	
	/** Method-1: Returning the Instance*/ 
	/** 
	 * @name PropertyManager
	 * @author Arif
	 * @date 09/10/2020
	 * @return
	 */
	public static PropertyManager getInstance()
	{
		// Creating an new instance of PropertyManager
		instance = new PropertyManager();
		
		// Loading the data from porperty file
		instance.loadProperty();
		
		// Return the instance
		return instance;
		
	}
	
	public void loadProperty()
	{
		// Instantiating the Property Class
		Properties prop = new Properties();
		
		// Reading the property file
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
		
		// Getting the baseUrl value from property file to the var
		baseUrl = prop.getProperty("baseURL");
		// Getting the browser value from property file into the var
		browser = prop.getProperty("browser");
	}
	
	public String getBaseUrl()
	{
		return baseUrl;
	}
	
	public String getBrowser()
	{
		return browser;
	}
}
