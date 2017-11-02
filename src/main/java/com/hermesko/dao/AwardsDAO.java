package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Awards;

public interface AwardsDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_awards table.
	 * 
	 * @param schoolId
	 * @param name
	 * @param date
	 */
	public void createAward(final int schoolId,
			final String name,
			final String date);
	
	/**
	 * Method used to read a record in the fn_awards table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Awards getAward(final int id);
	
	/**
	 * Method used to update a record in the fn_awards table.
	 * 
	 * @param id
	 * @param schoolId
	 * @param name
	 * @param date
	 */
	public void updateAward(final int id,
			final int schoolId,
			final String name,
			final String date);
	
	/**
	 * Method used to delete a record in the fn_awards table.
	 * 
	 * @param id
	 */
	public void deleteAward(final int id);
	
	/**
	 * Method used to list all of the records in the fn_awards table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Awards> listAwards();
}
