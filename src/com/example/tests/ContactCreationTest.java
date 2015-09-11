
package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void testContactCreationValidData(ContactData contactForm) throws Exception {

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openHomePage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactForm();
				// contactForm.groupname = "name2";
		app.getContactHelper().fillContactForm(contactForm);
		app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		// assertEquals(newList.size(), oldList.size()+1);
		app.getContactHelper().fillFirstLastName(contactForm);
		oldList.add(contactForm);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

}