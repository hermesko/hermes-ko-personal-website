package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.Coursework;

public interface CourseworkDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_coursework table.
	 * 
	 * @param schoolId
	 * @param course
	 */
	public void createCoursework(final int schoolId,
			final String course);
	
	/**
	 * Method used to read a record in the fn_coursework table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public Coursework getCoursework(final int id);
	
	/**
	 * Method used to update a record in the fn_coursework table.
	 * 
	 * @param id
	 * @param schoolId
	 * @param course
	 */
	public void updateCoursework(final int id,
			final int schoolId,
			final String course);
	
	/**
	 * Method used to delete a record in the fn_coursework table.
	 * 
	 * @param id
	 */
	public void deleteCouresework(final int id);
	
	/**
	 * Method used to list all of the records in the fn_coursework table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<Coursework> listCoursework();
}
