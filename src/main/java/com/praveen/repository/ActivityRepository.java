package com.praveen.repository;

import java.util.List;

import com.praveen.model.Activity;

public interface ActivityRepository {

	public abstract List<Activity> findAllActivity();

}