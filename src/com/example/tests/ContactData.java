package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String first_name;
	private String last_name;
	private String address;
	private String home;
	private String mobile_phone;
	private String work;
	private String email1;
	private String email2;
	private String day;
	private String month;
	private String year;
	private String address2;
	private String phone2;
	private String groupname;
	

	public ContactData() {

	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name=" + last_name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		return true;
	}

	public int compareTo(ContactData other) {
		return this.first_name.toLowerCase().compareTo(other.first_name.toLowerCase());
		}


	public ContactData withFirstName(String first_name) {
		this.first_name = first_name;
		return this;
	}


	public ContactData withLastName(String last_name) {
		this.last_name = last_name;
		return this;
	}


	public ContactData withAddress(String address) {
		this.address = address;
		return this;
	}


	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withGroupname (String groupname) {
		this.groupname = groupname;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}


	public ContactData withEmail(String email1) {
		this.email1 = email1;
		return this;
	}

	public String getFirst_name() {
		return first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public String getAddress() {
		return address;
	}


	public String getHome() {
		return home;
	}
	
	public String getMobile_phone() {
		return home;
	}

	public String getEmail1() {
		return email1;
	}


	public String getAddress2() {
		return address2;
	}

}