package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Technologies;

public interface TechnologiesDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_technologies table.
	 * 
	 * @param technologies
	 */
	public void createTechnologies(final String technologies);
	
	/**
	 * Method used to read a record in the fn_technologies table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Technologies getTechnologies(final int id);
	
	/**
	 * Method used to update a record in the fn_technologies table.
	 * 
	 * @param id
	 * @param technology
	 */
	public void updateTechnologies(final int id,
			final String technology);
	
	/**
	 * Method used to delete a record in the fn_technologies table.
	 * 
	 * @param id
	 */
	public void deleteTechnologies(final int id);
	
	/**
	 * Method used to list all of the records in the fn_technologies table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Technologies> listTechnologies();
}
