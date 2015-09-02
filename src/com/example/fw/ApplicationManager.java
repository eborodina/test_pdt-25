package com.example.fw;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager { 
	public WebDriver driver;
    public String baseUrl;
      
    
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
	
	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "https://localhost/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 //1-� ������ - ��������������� ������������� 
		// navigationHelper = new NavigationHelper(this); 
		// groupHelper = new GroupHelper(this);
		// contactHelper = new ContactHelper(this);
	}
	// 2-� ������
	public NavigationHelper getNavigationHelper(){
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
