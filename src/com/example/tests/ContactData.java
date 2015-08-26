package com.example.tests;

public class ContactData {
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
	public String home2;
    public String groupname ;

	public ContactData(String first_name, String last_name,
			String address, String home, String mobile_phone, String work,
			String email1, String email2, String day, String month,String year,
			 String address2, String home2, String groupname) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.home = home;
		this.mobile_phone = mobile_phone;
		this.work = work;
		this.email1 = email1;
		this.email2 = email2;
		this.day = day;
		this.month = month;
		this.year = year;
		this.address2 = address2;
		this.home2 = home2;
		this.groupname = groupname;
	}
	public ContactData() {
		
	}
}