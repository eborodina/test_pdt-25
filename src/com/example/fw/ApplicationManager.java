package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.tests.TestBase;

public class ApplicationManager { public static WebDriver driver;
public static String baseUrl;
private static StringBuffer verificationErrors = new StringBuffer();

public static boolean acceptNextAlert = true;
	
	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "https://localhost/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void returnToGroupsPage() {
		driver.findElement(By.linkText("group page")).click();
	}

	public void returnToHomePage() {
			
		    driver.findElement(By.linkText("home page")).click();
		}

	public void submitContactCreation() {
			driver.findElement(By.name("submit")).click();
		}

	public void fillContactForm(TestBase testBase, ContactData contactForm) {
			
		    driver.findElement(By.name("firstname")).clear();
		    driver.findElement(By.name("firstname")).sendKeys(contactForm.first_name);
		    driver.findElement(By.name("lastname")).clear();
		    driver.findElement(By.name("lastname")).sendKeys(contactForm.last_name);
		    driver.findElement(By.name("address")).clear();
		    driver.findElement(By.name("address")).sendKeys(contactForm.address);
		    driver.findElement(By.name("home")).clear();
		    driver.findElement(By.name("home")).sendKeys(contactForm.home);
		    driver.findElement(By.name("mobile")).clear();
		    driver.findElement(By.name("mobile")).sendKeys(contactForm.mobile_phone);
		    driver.findElement(By.name("work")).clear();
		    driver.findElement(By.name("work")).sendKeys(contactForm.work);
		    driver.findElement(By.name("email")).clear();
		    driver.findElement(By.name("email")).sendKeys(contactForm.email1);
		    driver.findElement(By.name("email2")).clear();
		    driver.findElement(By.name("email2")).sendKeys(contactForm.email2);
		    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contactForm.day);
		    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contactForm.month);
		    driver.findElement(By.name("byear")).clear();
		    driver.findElement(By.name("byear")).sendKeys(contactForm.year);
		    //new Select(driver.findElement(By.name("group_name"))).selectByVisibleText(contactForm.groupname);
		    driver.findElement(By.name("address2")).clear();
		    driver.findElement(By.name("address2")).sendKeys(contactForm.address2);
		    driver.findElement(By.name("phone2")).clear();
		    driver.findElement(By.name("phone2")).sendKeys(contactForm.home2);
		}

	public void initContactForm() {
			
		    driver.findElement(By.linkText("add new")).click();
		}

	public void submitGroupCreation() {
			driver.findElement(By.name("submit")).click();
		}

	public void fillGroupForm(TestBase testBase, GroupData group) {
			driver.findElement(By.name("group_name")).clear();
		    driver.findElement(By.name("group_name")).sendKeys(group.groupname);
		    driver.findElement(By.name("group_header")).clear();
		    driver.findElement(By.name("group_header")).sendKeys(group.header);
		    driver.findElement(By.name("group_footer")).clear();
		    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
		}

	public void initGroupCreation() {
			driver.findElement(By.name("new")).click();
		}

	public void gotoGroupsPage() {
			driver.findElement(By.linkText("groups")).click();
		}

	public void openHomePage() {
			
		    driver.findElement(By.linkText("home")).click();
		}

	public void openMainPage() {
			
			driver.get(baseUrl + "addressbookv4.1.4/");
		}

	public boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		}

	public boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

	public String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

	public void stop() {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
		
	}

}
