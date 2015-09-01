package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase {
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openHomePage();
		app.getContactHelper().deleteContact(1);
		app.getContactHelper().returnToHomePage();
		
	}

}
