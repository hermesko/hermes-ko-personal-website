package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.CourseworkDAO;
import com.hermesko.mapper.CourseworkMapper;
import com.hermesko.model.Coursework;

public class CourseworkJDBCTemplate implements CourseworkDAO{

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createCoursework(final int schoolId, 
			final String course) {
		String sqlStatement = "INSERT INTO FN_COURSEWORK (SCHOOL_ID, COURSE) values (?, ?)";
		jdbcTemplateObject.update(sqlStatement, schoolId, course);
		System.out.println("INSERTED: " + schoolId + ' ' + course);
	}

	public Coursework getCoursework(final int id) {
		String sqlStatement = "SELECT * FROM FN_COURSEWORK WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new CourseworkMapper());
	}

	public void updateCoursework(final int id, 
			final int schoolId, 
			final String course) {
		String sqlStatement = "UPDATE FN_COURSEWORK SET SCHOOL_ID = ?, COURSE = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, schoolId, course, id);
		System.out.println("UPDATED: " + id);
	}

	public void deleteCoursework(final int id) {
		String sqlStatement = "DELETE FROM FN_COURSEWORK WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<Coursework> listCoursework() {
		String sqlStatement = "SELECT * FROM FN_COURSEWORK";
		return jdbcTemplateObject.query(sqlStatement, new CourseworkMapper()).stream();
	}

}
