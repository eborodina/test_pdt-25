package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openHomePage();

		// save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		// action
		app.getContactHelper().deleteContact(0);
		app.getContactHelper().returnToHomePage();

		// save new state
		List<ContactData> newList = app.getContactHelper().getContacts();

		// compare states
		oldList.remove(0);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList, oldList);

	}
}