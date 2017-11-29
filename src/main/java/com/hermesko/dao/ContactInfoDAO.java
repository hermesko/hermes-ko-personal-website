package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import com.hermesko.model.ContactInfo;

public interface ContactInfoDAO {
	
	/**
	 * Method used to initialize the database resources connection
	 * 	
	 * @param ds
	 */
	public void setDataSource(final DataSource ds);
	
	/**
	 * Method used to create a record in the fn_contact_info table.
	 * 
	 * @param name
	 * @param city
	 * @param state
	 * @param phone
	 * @param email
	 * @param github
	 * @param linkedin
	 */
	public void createContactInfo(final String name, 
			final String city,
			final String state,
			final String phone,
			final String email,
			final String github,
			final String linkedin);
	
	/**
	 * Method used to read a record in the fn_contact_info table.
	 * 
	 * @param id
	 * 
	 * @return record corresponding to parameter id
	 */
	public ContactInfo getContactInfo(final int id);
	
	/**
	 * Method used to update a record in the fn_contact_info table.
	 * 
	 * @param id
	 * @param name
	 * @param city
	 * @param state
	 * @param phone
	 * @param email
	 * @param github
	 * @param linkedin
	 */
	public void updateContactInfo(final int id,
			final String name, 
			final String city,
			final String state,
			final String phone,
			final String email,
			final String github,
			final String linkedin);
	
	/**
	 * Method used to delete a record in the fn_contact_info table.
	 * 
	 * @param id
	 */
	public void deleteContactInfo(final int id);
	
	/**
	 * Method used to list all of the records in the fn_contact_info table.
	 * 
	 * @return stream object containing all records
	 */
	public Stream<ContactInfo> listContactInfo();
}
