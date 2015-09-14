
package com.example.tests;

import java.util.Collections;
import java.util.List;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class GroupCreationTest1 extends TestBase {

	

	@Test(dataProvider = "randomValidGroupGenerator")
	public void testGroupCreationValidData(GroupData group) throws Exception {
		
		// save old state
		List<GroupData> oldList = app.getGroupHelper().getGroups();

		// action
		app.getGroupHelper().createGroup(group);
		/*app.getGroupHelper()
		.initGroupCreation()
		.fillGroupForm(group)
		.submitGroupCreation()
		.returnToGroupsPage();
*/
		// save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		// compare states
		// assertEquals(newList.size(), oldList.size()+1);
		oldList.add(group);
		Collections.sort(oldList);
		assertEquals(newList, oldList);
	}

}
