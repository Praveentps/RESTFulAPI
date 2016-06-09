package com.praveen.repository;

import java.util.ArrayList;
import java.util.List;

import com.praveen.model.Activity;
import com.praveen.model.ActivitySearch;
import com.praveen.model.User;

/**
 * Created by vagrant on 05/06/16.
 */
public class ActivityRepositoryStub implements ActivityRepository {
	/* (non-Javadoc)
	 * @see com.praveen.repository.ActivityRepository#findAllActivity()
	 */
	
	public void create(Activity activity) {
		
		//should issue  insert statement to the db 
	};
	
	@Override
	public List<Activity> findByConstraints(ActivitySearch search) {
		List<Activity> activities = new ArrayList<Activity>();
		System.out.println(search.getDurationFrom());
		System.out.println(search.getSearchType());
		Activity activity= new Activity();
		activity.setId("1234");
		activity.setDuration(50);
		activity.setDescription("Swimming");
		activities.add(activity);
		return activities;
	}
	@Override
	public List<Activity> findByDescription(List<String> descriptions,int durationFrom,int durationTo) {
		//select * from Activities where description in (?,?,?) and duration ? and duration?
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity= new Activity();
		activity.setId("1234");
		activity.setDuration(50);
		activity.setDescription("Swimming");
		activities.add(activity);
		return activities;
	}
	@Override
	public void delete(String activityId) {
	//delete from activity where activityId=?
		
	}
	@Override
	public Activity update(Activity activity) {
	//search the data base to see activity id is exist 
	//select * from Activity where id=?
		//should issue the stmt to insert into db
		//if rs size=0
		//insert into Activity table else update Activity table	
		
	return activity;	
	}
	
	@Override
	public List<Activity> findAllActivity (){
		List<Activity> activities = new ArrayList<Activity>();
		Activity activity1 = new Activity();
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activities.add(activity1);
		
		Activity activity2 = new Activity();
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		activities.add(activity2);
		return activities;
	}
	@Override
	public Activity findActivity() {
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		User user = new User();
		user.setId("556");
		user.setName("praveen");
		activity1.setUser(user);
		
		return activity1;
	}
	@Override
	public Activity findActivity(String activityId) {
		if(activityId.equals("7777")){
			return null;
		}
		Activity activity1 = new Activity();
		activity1.setId("1234");
		activity1.setDescription("running");
		activity1.setDuration(55);
		User user = new User();
		user.setId("556");
		user.setName("praveen");
		activity1.setUser(user);
		
		return activity1;
	}
}
