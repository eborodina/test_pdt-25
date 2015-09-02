package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void submitContactCreation() {
			click(By.name("submit"));
		}

	public void fillContactForm(ContactData contactForm) {
			type(By.name("firstname"),contactForm.first_name);
		    type(By.name("lastname"),contactForm.last_name);
		    type(By.name("address"),contactForm.address);
		    type(By.name("home"),contactForm.home);
		    type(By.name("mobile"),contactForm.mobile_phone);
		    type(By.name("work"),contactForm.work);
		    type(By.name("email"),contactForm.email1);
		    type(By.name("email2"),contactForm.email2);
		    selectByText(By.name("bday"), contactForm.day);
		    selectByText(By.name("bmonth"), contactForm.month);
		  //  selectByText(By.name("group_name"), contactForm.groupname);
		    type(By.name("byear"),contactForm.year);
		    type(By.name("address2"),contactForm.address2);
		    type(By.name("phone2"),contactForm.phone2);
		    
		}

	public void initContactForm() {
			click(By.linkText("add new"));
		}

	public void returnToHomePage() {
			
		    click(By.linkText("home page"));
		}

	public void deleteContact(int index) {
		//click(By.xpath("//input[@id='id" +index+"']"));
		click(By.xpath("(//img[@alt='Edit'])["+index+"]"));
	    click(By.xpath("(//input[@name='update'][@value='Delete'])"));
	 		
	}

	public void updateContact() {
			click(By.xpath("(//input[@name='update'][@value='Update'])"));	
		
	}

	public void initContactModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])["+index+"]"));
			}

	}
