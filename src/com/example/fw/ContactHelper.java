package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
	private SortedListOf<ContactData> cachedContacts;

	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCacheContact();
		}
		return cachedContacts;
	}
	
	private void rebuildCacheContact() {
		cachedContacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		List<WebElement> contactRows = getContactRows();
		for (WebElement row : contactRows) {
			ContactData contact = new ContactData();
        contact
        .withLastName(row.findElement(By.xpath("./td[2]")).getText())
        .withFirstName(row.findElement(By.xpath("./td[3]")).getText());
        
        cachedContacts.add(contact);
 		}
		
	}
  
	public ContactHelper createContact(ContactData contactForm) {
		manager.navigateTo().contactForm();
		fillContactForm(contactForm, CREATION);
		submitContactCreation();
		returnToHomePage();
		rebuildCacheContact();
		return this;
				
	}
	
	public ContactHelper deleteContact(int index) {
		deletionContact(index);
		returnToHomePage();
		rebuildCacheContact();
		return this;
	}

	public ContactHelper modifyContact(int index, ContactData contactForm) {
		manager.navigateTo().mainPage();
		initContactModification(index);
		fillContactForm(contactForm, MODIFICATION);
		updateContact();
		returnToHomePage();
		rebuildCacheContact();
		return this;
				
	}
	
	// ---------------------------------------
	public ContactHelper deletionContact(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		click(By.xpath("(//input[@name='update'][@value='Delete'])"));
		cachedContacts = null;
		return this;
		
	}
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper fillContactForm(ContactData contactForm, boolean formType) {
		type(By.name("firstname"), contactForm.getFirst_name());
		type(By.name("lastname"), contactForm.getLast_name());
		type(By.name("address"), contactForm.getAddress());
		type(By.name("home"), contactForm.getHomePhone());
		type(By.name("mobile"), contactForm.getMobilePhone());
		type(By.name("email"), contactForm.getEmail1());
		type(By.name("address2"), contactForm.getAddress2());
			return this;
	}

	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	
	public ContactHelper updateContact() {
		click(By.xpath("(//input[@name='update'][@value='Update'])"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath("(//img[@alt='Edit'])[" + (index + 1) + "]"));
		return this;
	}

	private List<WebElement> getContactRows() {
		List<WebElement> contactRows = driver.findElements(By.xpath ("//tr[@name='entry']"));
			return contactRows;
	}


}
