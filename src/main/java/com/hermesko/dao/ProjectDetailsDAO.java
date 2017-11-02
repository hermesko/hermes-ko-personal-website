package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.ProjectDetails;

public interface ProjectDetailsDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_project_details table.
	 * 
	 * @param projectId
	 * @param detail
	 */
	public void createProjectDetails(final int projectId,
			final String detail);
	
	/**
	 * Method used to read a record in the fn_project_details table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public ProjectDetails getProjectDetails(final int id);
	
	/**
	 * Method used to update a record in the fn_project_details table.
	 * 
	 * @param id
	 * @param projectId
	 * @param detail
	 */
	public void updateProjectDetails(final int id,
			final int projectId,
			final String detail);
	
	/**
	 * Method used to delete a record in the fn_project_details table.
	 * 
	 * @param id
	 */
	public void deleteProjectDetails(final int id);
	
	/**
	 * Method used to list all of the records in the fn_project_details table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<ProjectDetails> listProjectDetails();
}
