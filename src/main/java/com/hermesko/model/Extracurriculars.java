package com.hermesko.model;

public class Extracurriculars {

	private final int id;
	private final String title, startDate, endDate;
	
	public Extracurriculars(final int id,
								final String title,
								final String startDate,
								final String endDate) {
		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getId() {
		return this.id;
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
