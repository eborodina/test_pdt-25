
package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


import static com.example.fw.ContactHelper.CREATION;

public class ContactCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void testContactCreationValidData(ContactData contactForm) throws Exception {

	//	app.navigateTo().mainPage();
//		app.navigateTo().openHomePage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contactForm);
		/*app.getContactHelper()
		.initContactForm()
		.fillContactForm(contactForm, CREATION)
		.submitContactCreation()
		.returnToHomePage();*/

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		// assertEquals(newList.size(), oldList.size()+1);
		oldList.add(contactForm);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);
	}

}