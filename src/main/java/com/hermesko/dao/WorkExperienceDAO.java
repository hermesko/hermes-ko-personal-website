package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.WorkExperience;

public interface WorkExperienceDAO {
	
	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_work_experience table.
	 * 
	 * @param company
	 * @param city
	 * @param state
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public void createWorkExperience(final String company,
			final String city,
			final String state,
			final String title,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to read a record in the fn_work_experience table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public WorkExperience getWorkExperience(final int id);
	
	/**
	 * Method used to update a record in the fn_work_experience table.
	 * 
	 * @param jobId
	 * @param company
	 * @param city
	 * @param state
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public void updateWorkExperience(final int jobId,
			final String company,
			final String city,
			final String state,
			final String title,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to delete a record in the fn_work_experience table.
	 * 
	 * @param id
	 */
	public void deleteWorkExperience(final int id);
	
	/**
	 * Method used to list all of the records in the fn_work_experience table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<WorkExperience> listWorkExperience();
}
