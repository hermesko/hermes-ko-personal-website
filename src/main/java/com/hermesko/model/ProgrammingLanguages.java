package com.hermesko.model;

public class ProgrammingLanguages {

	private final int id;
	private final String programmingLanguage;
	
	public ProgrammingLanguages(final int id,
									final String programmingLanguage) {
		this.id = id;
		this.programmingLanguage = programmingLanguage;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getProgrammingLanauage() {
		return this.programmingLanguage;
	}
}
