package com.praveen.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.praveen.model.Activity;

public class ActivityClient {
public Client client;

public ActivityClient() {
	client = ClientBuilder.newClient();
}
public Activity get(String id){
	//http://localhost:8080/RESTFulAPI/webapi/activities/1234
	WebTarget target = client.target("http://localhost:8080/RESTFulAPI/webapi/");
Activity response = target.path("activities/"+id).request().get(Activity.class);
return response;
}
}
