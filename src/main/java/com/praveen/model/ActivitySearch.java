package com.praveen.model;

import java.util.List;

public class ActivitySearch {
private int durationFrom;
private int durationTo;
private List<String> description;
private ActivitySearchType searchType;

public ActivitySearchType getSearchType() {
	return searchType;
}
public void setSearchType(ActivitySearchType searchType) {
	this.searchType = searchType;
}
public List<String> getDescription() {
	return description;
}
public int getDurationFrom() {
	return durationFrom;
}
public int getDurationTo() {
	return durationTo;
}
public void setDescription(List<String> description) {
	this.description = description;
}
public void setDurationFrom(int durationFrom) {
	this.durationFrom = durationFrom;
}
public void setDurationTo(int durationTo) {
	this.durationTo = durationTo;
}

}
