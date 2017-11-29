package com.hermesko.model;

public class Projects {

	private final int projectId;
	private final String name, purpose, startDate, endDate;
	
	public Projects(final int projectId,
						final String name,
						final String purpose,
						final String startDate,
						final String endDate) {
		this.projectId = projectId;
		this.name = name;
		this.purpose = purpose;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getProjectId() {
		return this.projectId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPurpose() {
		return this.purpose;
	}
	
	public String getStartDate() {
		return this.startDate;
	}
	
	public String getEndDate() {
		return this.endDate;
	}
}
