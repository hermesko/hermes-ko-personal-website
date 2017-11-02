package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.WorkResponsibilities;

public interface WorkResponsibilitiesDAO {
	
	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_work_responsibilities table.
	 * 
	 * @param jobId
	 * @param responsibility
	 */
	public void createWorkResponsibilities(final int jobId,
			final String responsibility);
	
	/**
	 * Method used to read a record in the fn_work_responsibilities table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public WorkResponsibilities getWorkResponsibilities(final int id);
	
	/**
	 * Method used to update a record in the fn_work_responsibilities table.
	 * 
	 * @param id
	 * @param jobId
	 * @param responsibility
	 */
	public void updateWorkResponsibilities(final int id,
			final int jobId,
			final String responsibility);
	
	/**
	 * Method used to delete a record in the fn_work_responsibilities table.
	 * 
	 * @param id
	 */
	public void deleteWorkResponsibilities(final int id);
	
	/**
	 * Method used to list all of the records in the fn_work_responsibilities table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<WorkResponsibilities> listWorkResponsibilities();
}
