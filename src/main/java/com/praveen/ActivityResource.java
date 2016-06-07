package com.praveen;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.persistence.internal.jpa.parsing.AvgNode;

import com.praveen.model.Activity;
import com.praveen.model.User;
import com.praveen.repository.ActivityRepository;
import com.praveen.repository.ActivityRepositoryStub;

@Path("activities")//http://localhost:8080/RESTFulAPI/webapi/activities
public class ActivityResource {
private ActivityRepository activityRepository = new ActivityRepositoryStub();

@POST
@Path("activity")//http://localhost:8080/RESTFulAPI/webapi/activities/activity //send the below body/*{"desc": "running","duration":"55"}*/
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Activity createActivity(Activity activity){
	System.out.println("how come here :"+activity.getDescription());
	System.out.println(activity.getDuration());
	
	activityRepository.create(activity);
	return activity;
}

@POST
@Path("activity")//http://localhost:8080/RESTFulAPI/webapi/activities/activity
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public Activity createActivityParams(MultivaluedMap<String,String> formParams){
	System.out.println(formParams.getFirst("description"));
	System.out.println(formParams.getFirst("duration"));
	
	Activity activity = new Activity();
	activity.setDescription("where is this"+formParams.getFirst("description"));
	activity.setDuration(Integer.parseInt(formParams.getFirst("duration")));
	
	activityRepository.create(activity);
	return  activity;
}

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public List<Activity> getAllActivities(){
	return activityRepository.findAllActivity();
}

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Path("{activityId}")//http://localhost:8080/RESTFulAPI/webapi/activities/1234
public Response getActivity(@PathParam ("activityId") String activityId){
	if(null==activityId || activityId.length()<4){
		return Response.status(Status.BAD_REQUEST).build();
	}
	Activity activity=activityRepository.findActivity(activityId);
	if(activity==null){
		return Response.status(Status.NOT_FOUND).build();
	}
	return Response.ok().entity(activity).build();
}

@GET
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Path("{activityId}/user")//http://localhost:8080/RESTFulAPI/webapi/activities/1234/user
public User getActivityUser(@PathParam ("activityId") String activityId){
	Activity activity = activityRepository.findActivity();
	User user = activity.getUser();
	return user;
	//return activityRepository.findActivity().getUser();
}

}
