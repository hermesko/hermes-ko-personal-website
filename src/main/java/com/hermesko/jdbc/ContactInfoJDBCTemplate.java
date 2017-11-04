package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.ContactInfoDAO;
import com.hermesko.mapper.ContactInfoMapper;
import com.hermesko.model.ContactInfo;

public class ContactInfoJDBCTemplate implements ContactInfoDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void createContactInfo(final String name, 
			final String city, 
			final String state, 
			final String phone, 
			final String email, 
			final String github,
			final String linkedin) {
		String sqlStatement = 
				"INSERT INTO FN_CONTACT_INFO (NAME, CITY, STATE, PHONE, EMAIL, GITHUB, LINKEDIN) values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement, name, city, state, phone, email, github, linkedin);
		System.out.println("INSERTED: " + name + ' ' + city + ' ' + state + ' ' + phone + ' ' + email + ' ' + github + ' ' + linkedin);
	}

	@Override
	public ContactInfo getContactInfo(final int id) {
		String sqlStatement = "SELECT * FROM FN_CONTACT_INFO WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new ContactInfoMapper());
	}

	@Override
	public void updateContactInfo(final int id, 
			final String name, 
			final String city, 
			final String state, 
			final String phone, 
			final String email,
			final String github, 
			final String linkedin) {
		String sqlStatement = 
				"UPDATE FN_CONTACT_INFO SET NAME = ?, CITY = ?, STATE = ?, PHONE = ?, EMAIL = ?, GITHUB = ?, LINKEDIN = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, name, city, state, phone, email, github, linkedin, id);
		System.out.println("UPDATED: " + id);
	}

	@Override
	public void deleteContactInfo(final int id) {
		String sqlStatement = "DELETE FROM FN_CONTACT_INFO WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	@Override
	public Stream<ContactInfo> listContactInfo() {
		String sqlStatement = "SELECT * FROM FN_CONTACT_INFO";
		return jdbcTemplateObject.query(sqlStatement,  new ContactInfoMapper()).stream();
	}

}
