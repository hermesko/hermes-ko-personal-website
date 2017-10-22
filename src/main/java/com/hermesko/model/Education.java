package com.hermesko.model;

public class Education {

	private final int schoolId;
	private final String institution, city, state, degreeType, major, gpa, latinHonors, conferralDate;
	
	public Education(final int schoolId, 
						final String institution, 
						final String city,
						final String state,
						final String degreeType,
						final String major,
						final String gpa,
						final String latinHonors,
						final String conferralDate) {
		this.schoolId = schoolId;
		this.institution = institution;
		this.city = city;
		this.state = state;
		this.degreeType = degreeType;
		this.major = major;
		this.gpa = gpa;
		this.latinHonors = latinHonors;
		this.conferralDate = conferralDate;
	}
	
	public int getSchoolId() {
		return this.schoolId;
	}
	
	public String getInstitution() {
		return this.institution;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public String getState() {
		return this.state;
	}
	public String getDegreeType() {
		return this.degreeType;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public String getGpa() {
		return this.gpa;
	}
	
	public String getLatinHonors() {
		return this.latinHonors;
	}
	
	public String getConferralDate() {
		return this.conferralDate;
	}
}
