package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.ExtracurricularsDAO;
import com.hermesko.mapper.ExtracurricularsMapper;
import com.hermesko.model.Extracurriculars;

public class ExtracurricularsJDBCTemplate implements ExtracurricularsDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createExtracurriculars(final String title, 
			final String startDate, 
			final String endDate) {
		String sqlStatement = "INSERT INTO FN_EXTRACURRICULARS (TITLE, START_DATE, END_DATE) values (?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement, title, startDate, endDate);
	}

	public Extracurriculars getExtracurriculars(final int id) {
		String sqlStatement = "SELECT * FROM FN_EXTRACURRICULARS WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new ExtracurricularsMapper());
	}

	public void updateExtracurriculars(final int id, 
			final String title, 
			final String startDate, 
			final String endDate) {
		String sqlStatement = "UPDATE FN_EXTRACURRICULARS SET TITLE = ?, START_DATE = ?, END_DATE = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, title, startDate, endDate, id);
		System.out.println("UPDATED: " + id);
	}

	public void deleteExtracurriculars(final int id) {
		String sqlStatement = "DELETE FROM FN_EXTRACURRICULARS WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<Extracurriculars> listExtracurriculars() {
		String sqlStatement = "SELECT * FROM FN_EXTRACURRICULARS";
		return jdbcTemplateObject.query(sqlStatement, new ExtracurricularsMapper()).stream();
	}

}
