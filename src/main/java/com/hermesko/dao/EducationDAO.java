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
	public void createEducation(final String institution, 
			final String city,
			final String state,
			final String degreeType,
			final String major,
			final String gpa,
			final String latinHonors,
			final String conferralDate);
	
	/**
	 * Method used to read a record in the fn_education table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Education getEducation(final int id);
	
	/**
	 * Method used to update a record in the fn_education table.
	 * 
	 * @param schoolId
	 * @param city
	 * @param state
	 * @param degreeType
	 * @param major
	 * @param gpa
	 * @param latinHonors
	 * @param conferralDate
	 */
	public void updateEducation(final int schoolId, 
			final String institution, 
			final String city,
			final String state,
			final String degreeType,
			final String major,
			final String gpa,
			final String latinHonors,
			final String conferralDate);
	
	/**
	 * Method used to delete a record in the fn_education table.
	 * 
	 * @param id
	 */
	public void deleteEducation(final int id);
	
	/**
	 * Method used to list all of the records in the fn_education table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Education> listEducation();
}
