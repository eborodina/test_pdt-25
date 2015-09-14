package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public List<ContactData> getContacts() {
		manager.navigateTo().openHomePage();
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> rows = getContactRows();
		for (WebElement row : rows) {
			String last_name = setLastNameInRow(row);
			if (last_name == null) {
				last_name = "";
			}
			String first_name = setFirstNameInRow(row);
			if (first_name == null) {
				first_name = "";
			}
			contacts.add(new ContactData().withFirstName(first_name).withLastName(last_name));
 		}
		return contacts;
	}

	public void createContact(ContactData contactForm) {
		initContactForm();
		fillContactForm(contactForm, CREATION);
		submitContactCreation();
		returnToHomePage();
		
	}
	
	public ContactHelper deleteContact(int index) {
		// click(By.xpath("//input[@id='id" +index+"']"));
		deletionContact(index);
		returnToHomePage();
		return this;
	}

	public void modifyContact(int index, ContactData contactForm) {
		initContactModification(index);
		fillContactForm(contactForm, MODIFICATION);
		updateContact();
		returnToHomePage();
		
	}
	
	// ---------------------------------------
	public void deletionContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		click(By.xpath("(//input[@name='update'][@value='Delete'])"));
	}
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contactForm, boolean formType) {
		type(By.name("firstname"), contactForm.getFirst_name());
		type(By.name("lastname"), contactForm.getLast_name());
		type(By.name("address"), contactForm.getAddress());
		type(By.name("home"), contactForm.getHome());
		type(By.name("mobile"), contactForm.getMobile_phone());
		// type(By.name("work"), contactForm.work);
		type(By.name("email"), contactForm.getEmail1());
		// type(By.name("email2"), contactForm.email2);
		// selectByText(By.name("bday"), contactForm.day);
		// selectByText(By.name("bmonth"), contactForm.month);
		if (formType == CREATION) {
			selectByText(By.name("groupname"), "group1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exists in contact modification form");
			}
		}
		// type(By.name("byear"), contactForm.year);
		type(By.name("address2"), contactForm.getAddress2());
		// type(By.name("phone2"), contactForm.phone2);
		return this;
	}

	public ContactHelper initContactForm() {
		click(By.linkText("add new"));
		return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	

	public ContactHelper updateContact() {
		click(By.xpath("(//input[@name='update'][@value='Update'])"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	public String setFirstNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[3]")).getText();
	}

	public String setLastNameInRow(WebElement row) {
		return row.findElement(By.xpath("./td[2]")).getText();
	}

	private List<WebElement> getContactRows() {
		return driver.findElements(By.xpath("//tr[@name='entry']"));
	}

	

	
}
