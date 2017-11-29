package com.hermesko.model;

public class WorkExperience {

	private final int jobId;
	private final String company, city, state, title, startDate, endDate;
	
	public WorkExperience(final int jobId,
							final String company,
							final String city,
							final String state,
							final String title,
							final String startDate,
							final String endDate) {
		this.jobId = jobId;
		this.company = company;
		this.city = city;
		this.state = state;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getJobId() {
		return this.jobId;
	}
	
	public String getCompany() {
		return this.company;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
}
