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
	public String toString() {
		return "ContactData [first_last=" + first_last + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first_last == null) ? 0 : first_last.hashCode());
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
		if (first_last == null) {
			if (other.first_last != null)
				return false;
		} else if (!first_last.equals(other.first_last))
			return false;
		return true;
	}

	public int compareTo(ContactData other) {
		return this.first_last.toLowerCase().compareTo(other.first_last.toLowerCase());
	}

}