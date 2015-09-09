package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
		@Test
		public void modificationSomeContact(){
			app.getNavigationHelper().openMainPage();
			app.getNavigationHelper().openHomePage();
			
			// save old state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
			//actions
			app.getContactHelper().initContactModification(0);
			ContactData contactForm = new ContactData();
			contactForm.last_name = "Abramov";
			contactForm.first_name = "Abram";
			app.getContactHelper().fillContactForm(contactForm);
			app.getContactHelper().updateContact();
			app.getContactHelper().returnToHomePage();
			
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();

			// compare states
			// assertEquals(newList.size(), oldList.size()+1);
			app.getContactHelper().fillFirstLastName(contactForm);
			oldList.remove(0);
			oldList.add(contactForm);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);
		}
	}