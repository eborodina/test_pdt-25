package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	   
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 3; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();
	}

	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 5 ; i++) {
		ContactData contactForm = new ContactData();
		contactForm.first_name = generateRandomStringContact();
		contactForm.last_name = generateRandomStringContact();
		contactForm.address = generateRandomStringContact();
		contactForm.home = generateRandomStringContact();
		contactForm.address2 = generateRandomStringContact();
		//contactForm.phone2 = generateRandomStringContact();
		contactForm.email1 = generateRandomStringContact();
		//contactForm.email2 = generateRandomStringContact();
		
		list.add(new Object[]{contactForm});
		}
		
		return list.iterator();
	}
	
	public String generateRandomStringContact() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "name2" + rnd.nextInt();
				}
				
	}

	}
