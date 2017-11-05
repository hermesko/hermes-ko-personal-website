package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.AwardsDAO;
import com.hermesko.mapper.AwardsMapper;
import com.hermesko.model.Awards;

public class AwardsJDBCTemplate implements AwardsDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createAward(final int schoolId, 
			final String name, 
			final String date) {
		String sqlStatement =
				"INSERT INTO FN_AWARDS (SCHOOL_ID, NAME, DATE) values (?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement, schoolId, name, date);
		System.out.println("INSERTED: " + schoolId + ' ' + name + ' ' + date);
	}

	public Awards getAward(final int id) {
		String sqlStatement = 
				"SELECT * FROM FN_AWARDS WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new AwardsMapper());
	}

	public void updateAward(final int id, 
			final int schoolId, 
			final String name, 
			final String date) {
		String sqlStatement = "UPDATE FN_AWARDS SET SCHOOL_ID = ?, NAME = ?, DATE = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, schoolId, name, date, id);
		System.out.println("UPDATED: " + id);

	}

	public void deleteAward(final int id) {
		String sqlStatement = "DELETE FROM FN_AWARDS WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<Awards> listAwards() {
		String sqlStatement = "SELECT * FROM FN_AWARDS";
		return jdbcTemplateObject.query(sqlStatement, new AwardsMapper()).stream();
	}

}
