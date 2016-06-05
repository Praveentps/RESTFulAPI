package com.praveen;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.praveen.model.Activity;
import com.praveen.repository.ActivityRepository;
import com.praveen.repository.ActivityRepositoryStub;

@Path("activities")//http://localhost:8080/RESTFulAPI/webapi/activities
public class ActivityResource {
private ActivityRepository activityRepository = new ActivityRepositoryStub();

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public List<Activity> getAllActivities(){
	return activityRepository.findAllActivity();
}

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Path("{activityId}")//http://localhost:8080/RESTFulAPI/webapi/activities/1234
public Activity getActivity(@PathParam ("activityId") String activityId){
	return activityRepository.findActivity();
}

}
