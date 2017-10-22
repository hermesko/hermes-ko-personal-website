package com.hermesko.model;

public class ProjectDetails {

	private final int id, projectId;
	private final String detail;
	
	public ProjectDetails(final int id,
							final int projectId,
							final String detail) {
		this.id = id;
		this.projectId = projectId;
		this.detail = detail;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int projectId() {
		return this.projectId;
	}
	
	public String getDetail() {
		return this.detail;
	}
}
