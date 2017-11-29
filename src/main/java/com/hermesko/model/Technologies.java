package com.hermesko.model;

public class Technologies {

	private final int id;
	private final String technology;
	
	public Technologies(final int id,
							final String technology) {
		this.id = id;
		this.technology = technology;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getTechnology() {
		return this.technology;
	}
}
