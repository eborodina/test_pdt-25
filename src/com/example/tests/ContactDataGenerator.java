package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length <3) {
				System.out.println("Please specify parameters: <amount of test data> <file> <format>");
				return;
			}
			int amount = Integer.parseInt(args[0]);
			File file = new File(args[1]);
			String format = args[2];
				
			if (file.exists()) {
				System.out.println("File '" +file+ "' exists. Please remove it");
				return;
			}

	List<ContactData> contacts = generateRandomContact(amount);
if ("csv".equals(format)) {
	saveContactsToCsvFile(contacts, file);
}else if ("xml".equals(format)) {
	saveContactsToXmlFile(contacts, file);
	} else {
		System.out.println("Unknoen format" + format);
		return;
	}

	}

	private static void saveContactsToXmlFile(List<ContactData> contact, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contact);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
				
	public static List<ContactData> loadContactFromXmlFile(File file){
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}


	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getLast_name()+ ","+ contact.getFirst_name()+ "," + 
		contact.getAddress()+ "," +contact.getHomePhone()+","+contact.getMobilePhone()+","+ 
					contact.getEmail1()+","+contact.getAddress2()+",!"+"\n");
			
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactFromCsvFile(File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			
		ContactData contact  = new ContactData()
				.withLastName(part[0])
				.withFirstName(part[1])
				.withAddress(part[2])
				.withHomePhone(part[3])
				.withMobilePhone(part[4])
				.withEmail(part[5])
				.withAddress2(part[6]);
		list.add(contact);
		line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	
	public static List<ContactData> generateRandomContact(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i = 0; i < amount; i++) {
			ContactData contact = new ContactData()
					.withFirstName(generateRandomStringContact())
					.withLastName(generateRandomStringContact())
					.withAddress(generateRandomStringContact())
					.withHomePhone(generateRandomStringContact())
					.withMobilePhone(generateRandomStringContact())
					.withEmail(generateRandomStringContact())
					.withAddress2(generateRandomStringContact());
			list.add(contact);
		}

		return list;
	}
	
	
	public static String generateRandomStringContact() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0) {
			return "";
		} else {
			return "name2" + rnd.nextInt();
		}

		
	}
}
