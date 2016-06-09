package com.praveen.client;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.praveen.model.Activity;
import com.praveen.model.ActivitySearch;
import com.praveen.model.ActivitySearchType;

public class ActivitySearchClientTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testActivitySearchClinet() {
		fail("Not yet implemented");
	}

@Test

public void testSearchObject(){
	ActivitySearchClient client = new ActivitySearchClient();
	List<String> searchValues= new ArrayList<String>();
	searchValues.add("biking");
	searchValues.add("runnig");
	ActivitySearch search = new ActivitySearch();
	search.setDescription(searchValues);
	search.setDurationFrom(30);
	search.setDurationTo(50);
	search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
	List<Activity> activities = client.search(search);
	System.out.println(activities);
	assertNotNull(activities);
	
}
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		String param = "description";
		List<String> searchValue = new ArrayList<String>();
		searchValue.add("Swimming");
		searchValue.add("running");
		
		String secondParam="durationFrom";
		int durationFrom=22;
		String thirdParam="durationTo";
		int durationTo=55;
		List<Activity> activities = client.search(param, searchValue,secondParam,durationFrom,thirdParam,durationTo);
		System.out.println(activities);
		assertNotNull(activities);
	}

}
