package com.hermesko.model;

public class WorkResponsibilities {

	private final int id, jobId;
	private final String responsibility;
	
	public WorkResponsibilities(final int id,
									final int jobId,
									final String responsibility) {
		this.id = id;
		this.jobId = jobId;
		this.responsibility = responsibility;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getJobId() {
		return this.jobId;
	}
	
	public String getResponsibility() {
		return this.responsibility;
	}
}
