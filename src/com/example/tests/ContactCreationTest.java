
package com.example.tests;

import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void testContactCreationValidData(ContactData contactForm) throws Exception {

		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();

		// actions
		app.getContactHelper().createContact(contactForm);
		
		// save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		assertThat(newList, equalTo(oldList.withAdded(contactForm)));
		
		
	}

}