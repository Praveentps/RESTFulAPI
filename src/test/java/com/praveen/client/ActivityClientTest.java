package com.praveen.client;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.praveen.model.Activity;

public class ActivityClientTest {

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
	public void testDelete(){
	ActivityClient client= new ActivityClient();
	client.delete("876");
	
	}
	
	@Test
	public void testPut(){
		Activity activity = new Activity();
		activity.setId("1456");
		activity.setDescription("Bikram yoga");
		activity.setDuration(90);
		
		ActivityClient client= new ActivityClient();
		activity=client.update(activity);
		assertNotNull(activity);
	}
	@Test
	public void testCreate(){
		ActivityClient client= new ActivityClient();
		Activity activity = new Activity();
		activity.setDescription("Swimming");
		activity.setDuration(99);
		activity= client.create(activity);
		assertNotNull(activity);
	}

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("1234");
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		
		List<Activity> activity = client.get();
		System.out.println(activity);
		assertNotNull(activity);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest(){
		ActivityClient client = new ActivityClient();
		client.get("123");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound(){
		ActivityClient client = new ActivityClient();
		client.get("7777");
	}
	
	
}
