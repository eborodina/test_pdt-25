package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
		@Test(dataProvider = "randomValidContactGenerator")
		public void modificationSomeContact(ContactData contactForm){
			app.getNavigationHelper().openMainPage();
			app.getNavigationHelper().openHomePage();
			
			// save old state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
			Random rnd = new Random();
			int index = rnd.nextInt(oldList.size()-1);
			
			//actions
			app.getContactHelper().initContactModification(index);
			app.getContactHelper().fillContactForm(contactForm);
			app.getContactHelper().updateContact();
			app.getContactHelper().returnToHomePage();
			
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();

			// compare states
			// assertEquals(newList.size(), oldList.size()+1);
			app.getContactHelper().fillFirstLastName(contactForm);
			oldList.remove(index);
			oldList.add(contactForm);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);
		}
	}