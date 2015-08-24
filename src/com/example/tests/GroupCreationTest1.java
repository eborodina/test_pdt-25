
package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest1 extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openManePage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.groupname = "name 1";
    group.header="header1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openManePage();
    gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
