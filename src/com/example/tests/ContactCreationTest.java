
	package com.example.tests;
	import org.testng.annotations.Test;

	public class ContactCreationTest extends TestBase {
	
		@Test
	  public void testContactFormCreation() throws Exception {
		  
		openMainPage();
		openHomePage();
	    initContactForm();
	    ContactData contactForm = new ContactData();
	    contactForm.first_name = "Ivan";
	    contactForm.last_name = "Ivanov";
	    contactForm.address = "SPb";
	    contactForm.home = "";
	    contactForm.address2 = "";
	    contactForm.home2 = "";
	    contactForm.email1 = "email1";
	    contactForm.email2 = "email2";
	    contactForm.day = "15";
	    contactForm.month = "March";
	    contactForm.year = "1985";
	    contactForm.mobile_phone = "1234567";
	   // contactForm.groupname = "name2";
	    fillContactForm(contactForm);
	    submitContactCreation();
	    returnToHomePage();
	  }

	}