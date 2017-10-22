package com.hermesko.model;

public class Coursework {

	private final int id, schoolId;
	private final String course;
	
	public Coursework(final int id,
						final int schoolId,
						final String course) {
		this.id = id;
		this.schoolId = schoolId;
		this.course = course;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getSchoolId() {
		return this.schoolId;
	}
	
	public String getCourse() {
		return this.course;
	}
}
