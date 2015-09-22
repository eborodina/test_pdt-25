
package com.example.tests;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupCreationTest1 extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> groupsFromFile() throws IOException {
	//	return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File ("groups.txt"))).iterator();
		return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File ("groups.xml"))).iterator();
	}
	
	@Test(dataProvider = "groupsFromFile")
	public void testGroupCreationValidData(GroupData group) throws Exception {
		
		// save old state
		SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();

		// action
		app.getGroupHelper().createGroup(group);
		
		// save new state
		SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
		
		// compare states
		
		assertThat(newList, equalTo(oldList.withAdded(group)));
		
	}


}
