
package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

	@Test
	public void testContactFormCreation() throws Exception {

		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openHomePage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().initContactForm();
		ContactData contactForm = new ContactData();
		contactForm.first_name = "Oleg";
		contactForm.last_name = "Abramov";
		contactForm.address = "SPb";
		contactForm.home = "";
		contactForm.address2 = "";
		contactForm.phone2 = "";
		contactForm.email1 = "email1";
		contactForm.email2 = "email2";
		contactForm.day = "15";
		contactForm.month = "March";
		contactForm.year = "1985";
		contactForm.mobile_phone = "123";
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