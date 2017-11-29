package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.TechnologiesDAO;
import com.hermesko.mapper.TechnologiesMapper;
import com.hermesko.model.Technologies;

public class TechnologiesJDBCTemplate implements TechnologiesDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createTechnologies(final String technologies) {
		String sqlStatement = "INSERT INTO FN_TECHNOLOGIES (TECHNOLOGY) VALUES (?)";
		jdbcTemplateObject.update(sqlStatement, technologies);
		System.out.println("INSERTED: " + technologies);
	}

	public Technologies getTechnologies(final int id) {
		String sqlStatement = "SELECT * FROM FN_TECHNOLOGIES WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new TechnologiesMapper());
	}

	public void updateTechnologies(final int id, final String technology) {
		String sqlStatement = "UPDATE FN_TECHNOLOGIES SET TECHNOLOGY = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, technology, id);
		System.out.println("UPDATED: " + id);
	}

	public void deleteTechnologies(final int id) {
		String sqlStatement = "DELETE FROM FN_TECHNOLOGIES WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);	
	}

	public Stream<Technologies> listTechnologies() {
		String sqlStatement = "SELECT * FROM FN_TECHNOLOGIES";
		return jdbcTemplateObject.query(sqlStatement, new TechnologiesMapper()).stream();
	}

}
