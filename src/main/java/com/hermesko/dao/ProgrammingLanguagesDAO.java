package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.ProgrammingLanguages;

public interface ProgrammingLanguagesDAO {

	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_programming_languages table.
	 * 
	 * @param programmingLanguage
	 */
	public void createProgrammingLanguages(final String programmingLanguage);
	
	/**
	 * Method used to read a record in the fn_programming_languages table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public ProgrammingLanguages getProgrammingLanguages(final int id);
	
	/**
	 * Method used to update a record in the fn_programming_languages table.
	 * 
	 * @param id
	 * @param programmingLanguage
	 */
	public void updateProgrammingLanguages(final int id,
			final String programmingLanguage);
	
	/**
	 * Method used to delete a record in the fn_programming_languages table.
	 * 
	 * @param id
	 */
	public void deleteProgrammingLanguages(final int id);
	
	/**
	 * Method used to list all of the records in the fn_programming_languages table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<ProgrammingLanguages> listProgrammingLanguages();
}
