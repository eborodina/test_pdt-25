package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	public String first_name;
	public String last_name;
	public String address;
	public String home;
	public String mobile_phone;
	public String work;
	public String email1;
	public String email2;
	public String day;
	public String month;
	public String year;
	public String address2;
	public String phone2;
	public String groupname;
	public String first_last;

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
	
}