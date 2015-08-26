package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTestCopy extends TestBase {
	
	  @Test
	  public void testNonEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    GroupData group = new GroupData();
	    group.groupname = "name2";
	    group.header="header1";
	    group.footer = "footer 1";
		fillGroupForm(group);
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
	  
	  @Test
	  public void testEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
	

}
