package com.praveen.repository;

import java.util.List;

import com.praveen.model.Activity;

public interface ActivityRepository {

	public abstract List<Activity> findAllActivity();

	public abstract Activity findActivity();

	public abstract void create(Activity activity);

	public abstract Activity findActivity(String activityId);

	public abstract Activity update(Activity activity);

	public abstract void delete(String activityId);

}