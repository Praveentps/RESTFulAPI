package com.praveen.client;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.praveen.model.Activity;

public class ActivityClient {
public Client client;

public ActivityClient() {
	client = ClientBuilder.newClient();
}
public Activity get(String id){
	//http://localhost:8080/RESTFulAPI/webapi/activities/1234
	WebTarget target = client.target("http://localhost:8080/RESTFulAPI/webapi/");
Response response = target.path("activities/"+id).request().get(Response.class);
if(response.getStatus()!=200){
	throw new RuntimeException(response.getStatus()+": there was error on server.");
}
return response.readEntity(Activity.class);
}

public List<Activity> get(){
	WebTarget target = client.target("http://localhost:8080/RESTFulAPI/webapi/");
	List<Activity> response = target.path("activities/").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
	return response;
}

}
