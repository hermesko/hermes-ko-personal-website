package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Extracurriculars;

public interface ExtracurricularsDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_extracurriculars table.
	 * 
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public void createExtracurriculars(final String title,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to read a record in the fn_extracurriculars table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Extracurriculars getExtracurriculars(final int id);
	
	/**
	 * Method used to update a record in the fn_extracurriculars table.
	 * 
	 * @param id
	 * @param title
	 * @param startDate
	 * @param endDate
	 */
	public void updateExtracurriculars(final int id,
			final String title,
			final String startDate,
			final String endDate);
	
	/**
	 * Method used to delete a record in the fn_extracurriculars table.
	 * 
	 * @param id
	 */
	public void deleteExtracurriculars(final int id);
	
	/**
	 * Method used to list all of the records in the fn_extracurriculars table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Extracurriculars> listExtracurriculars();
}
