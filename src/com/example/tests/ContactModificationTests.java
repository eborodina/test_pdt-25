package com.example.tests;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
		@Test
		public void modificationSomeContact(){
			app.getNavigationHelper().openMainPage();
			app.getNavigationHelper().openHomePage();
			app.getContactHelper().initContactModification(3);
			ContactData contactForm = new ContactData();
			contactForm.last_name = "Petrov";
			app.getContactHelper().fillContactForm(contactForm);
			app.getContactHelper().updateContact();
			app.getContactHelper().returnToHomePage();
		}
	}