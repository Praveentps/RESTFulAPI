package com.praveen.client;

import java.net.URI;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.praveen.model.Activity;
import com.praveen.model.ActivitySearch;

public class ActivitySearchClient {
	private Client client;

	public ActivitySearchClient() {
		client = ClientBuilder.newClient();

	}

	public List<Activity> search(ActivitySearch search) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTFulAPI/webapi/")
				.path("search/activities")
				.build();
		WebTarget target = client.target(uri);
		Response response =target.request(MediaType.APPLICATION_JSON).post(Entity.entity(search,MediaType.APPLICATION_JSON));
		if(response.getStatus()!=200){
			throw new RuntimeException(response.getStatus()+"There was error at server");
		}
		return response.readEntity(new GenericType<List<Activity>>(){});
	}
	
	public List<Activity> search(String param, List<String> searchValues, String secondParam, int durationFrom, String thirdParam, int durationTo) {
		URI uri = UriBuilder.fromUri("http://localhost:8080/RESTFulAPI/webapi/")
				.path("search/activities")
				.queryParam(secondParam, durationFrom)
				.queryParam(thirdParam, durationTo)
				.queryParam(param, searchValues).build();
		WebTarget target = client.target(uri);
		List<Activity> response = target.request(MediaType.APPLICATION_JSON).get(new GenericType<List<Activity>>(){});
		System.out.println(response);
		return response;
	}

	
}
