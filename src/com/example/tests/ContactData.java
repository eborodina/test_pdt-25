package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String first_name;
	private String last_name;
	private String address;
	private String home_phone;
	private String mobile_phone;
	private String email1;
	private String address2;

	public ContactData() {

	}

	@Override
	public String toString() {
		return "ContactData [first_name=" + first_name + ", last_name=" + last_name + "]";
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
		int result;
		result = this.last_name.toLowerCase().compareTo (other.last_name.toLowerCase());
		if (result == 0) {
			result = this.first_name.toLowerCase().compareTo (other.first_name.toLowerCase());
		}
		
		return result;

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

	public ContactData withHomePhone(String home_phone) {
		this.home_phone = home_phone;
		return this;
	}

	public ContactData withMobilePhone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
		return this;
	}

	public ContactData withEmail(String email1) {
		this.email1 = email1;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
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

	public String getHomePhone() {
		return home_phone;
	}

	public String getMobilePhone() {
		return mobile_phone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getAddress2() {
		return address2;
	}

}