package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Education;

public interface EducationDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_education table.
	 * 
	 * @param city
	 * @param state
	 * @param degreeType
	 * @param major
	 * @param gpa
	 * @param latinHonors
	 * @param conferralDate
	 */
	public void createEducation(String institution, 
			String city,
			String state,
			String degreeType,
			String major,
			String gpa,
			String latinHonors,
			String conferralDate);
	
	/**
	 * Method used to read a record in the fn_education table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Education getEducation(int id);
	
	/**
	 * Method used to update a record in the fn_education table.
	 * 
	 * @param city
	 * @param state
	 * @param degreeType
	 * @param major
	 * @param gpa
	 * @param latinHonors
	 * @param conferralDate
	 */
	public void updateEducation(int schoolId, 
			String institution, 
			String city,
			String state,
			String degreeType,
			String major,
			String gpa,
			String latinHonors,
			String conferralDate);
	
	/**
	 * Method used to delete a record in the fn_education table.
	 * 
	 * @param id
	 */
	public void deleteEducation(int id);
	
	/**
	 * Method used to list all of the records in the fn_education table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Education> listEducation();
}
