package com.praveen;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.praveen.model.Activity;
import com.praveen.repository.ActivityRepository;
import com.praveen.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {
private ActivityRepository activityRepository = new ActivityRepositoryStub();

@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Activity> getAllActivities(){
	return activityRepository.findAllActivity();
}
}
