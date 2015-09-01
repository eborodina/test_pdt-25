
package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest1 extends TestBase {
	
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    GroupData group = new GroupData();
    group.groupname = "name2";
    group.header="header1";
    group.footer = "footer 1";
	app.fillGroupForm(this, group);
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	app.openMainPage();
    app.gotoGroupsPage();
    app.initGroupCreation();
    app.fillGroupForm(this, new GroupData("", "", ""));
    app.submitGroupCreation();
    app.returnToGroupsPage();
  }
}
