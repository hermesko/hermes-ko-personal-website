package com.hermesko.model;

public class Awards {
	
	private final int id, schoolId;
	private final String name, date;
	
	public Awards (final int id,
					final int schoolId,
					final String name,
					final String date) {
		this.id = id;
		this.schoolId = schoolId;
		this.name = name;
		this.date = date;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getSchoolId() {
		return this.schoolId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDate() {
		return this.date;
	}
}
