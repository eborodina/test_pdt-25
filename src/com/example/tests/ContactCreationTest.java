
package com.example.tests;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;


import static com.example.tests.ContactDataGenerator.loadContactFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactFromXmlFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactCreationTest extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactFromFile() throws IOException {
//	return convertContactForDataProvider(loadContactFromCsvFile(new File ("contact.txt"))).iterator();
	return convertContactForDataProvider(loadContactFromXmlFile(new File ("contact.xml"))).iterator();
}
	
	

	@Test (dataProvider = "contactFromFile")
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