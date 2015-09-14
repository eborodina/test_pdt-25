package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {
	
		@Test(dataProvider = "randomValidContactGenerator")
		public void modificationSomeContact(ContactData contactForm){
	//		app.navigateTo().mainPage();
//			app.navigateTo().openHomePage();
			
			// save old state
			List<ContactData> oldList = app.getContactHelper().getContacts();
			
			Random rnd = new Random();
			int index = rnd.nextInt(oldList.size()-1);
			
			//actions
			app.getContactHelper().modifyContact(index, contactForm);
			/*app.getContactHelper()
			.initContactModification(index)
			.fillContactForm(contactForm, MODIFICATION)
			.updateContact()
			.returnToHomePage();*/
			
			// save new state
			List<ContactData> newList = app.getContactHelper().getContacts();

			// compare states
			// assertEquals(newList.size(), oldList.size()+1);
			
			oldList.remove(index);
			oldList.add(contactForm);
			Collections.sort(oldList);
			Collections.sort(newList);
			assertEquals(newList, oldList);
		}
	}