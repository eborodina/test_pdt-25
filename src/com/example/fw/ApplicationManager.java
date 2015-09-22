package com.example.fw;

import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager { 
	public WebDriver driver;
    public String baseUrl;
      
    
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
	private Properties properties;
	
	public ApplicationManager(Properties properties){
		 this.properties = properties;
		 String browser = properties.getProperty("browser");
		 if ("firefox".equals(browser)) {
			 driver = new FirefoxDriver();
		 } else if ("ie".equals(browser)) {
			 driver = new InternetExplorerDriver() ;
			 } else {
				 throw new Error ("Unsupported browser: " + browser);
			 }
		 
		
		 baseUrl = properties.getProperty("baseUrl");
	//	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(baseUrl);
				 
		 //1-й способ - ѕредварительна€ инициализаци€ 
		// navigationHelper = new NavigationHelper(this); 
		// groupHelper = new GroupHelper(this);
		// contactHelper = new ContactHelper(this);
	}
	// 2-й способ
	public NavigationHelper navigateTo(){
		if(navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper(){
		if(groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper(){
		if(contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public void stop() {
		driver.quit();
	  
	 }
}
