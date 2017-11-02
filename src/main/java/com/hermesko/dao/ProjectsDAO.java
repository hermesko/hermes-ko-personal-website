package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Projects;

public interface ProjectsDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_projects table.
	 * 
	 * @param name
	 * @param purpose
	 * @param startDate
	 * @param endDate
	 */
	public void createProjects(final String name,
			final String purpose,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to read a record in the fn_projects table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Projects getProjects(final int id);
	
	/**
	 * Method used to update a record in the fn_projects table.
	 * 
	 * @param projectId
	 * @param name
	 * @param purpose
	 * @param startDate
	 * @param endDate
	 */
	public void updateProjects(final int projectId,
			final String name,
			final String purpose,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to delete a record in the fn_projects table.
	 * 
	 * @param id
	 */
	public void deleteProjects(final int id);
	
	/**
	 * Method used to list all of the records in the fn_projects table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Projects> listProjects();
}
