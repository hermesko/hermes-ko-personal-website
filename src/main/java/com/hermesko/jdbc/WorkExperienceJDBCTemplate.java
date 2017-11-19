package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.WorkExperienceDAO;
import com.hermesko.mapper.WorkExperienceMapper;
import com.hermesko.model.WorkExperience;

public class WorkExperienceJDBCTemplate implements WorkExperienceDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createWorkExperience(final String company, 
			final String city, 
			final String state, 
			final String title, 
			final String startDate,
			final String endDate) {
		String sqlStatement = "INSERT INTO FN_WORK_EXPERIENCE (COMPANY, CITY, STATE, TITLE, START_DATE, END_DATE) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement, company, city, state, title, startDate, endDate);
		System.out.println("INSERTED: " + company + ' ' + city + ' ' + state + ' ' + title + ' ' + startDate + ' ' + endDate);
	}

	public WorkExperience getWorkExperience(final int id) {
		String sqlStatement = "SELECT * FROM FN_WORK_EXPERIENCE WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new WorkExperienceMapper());
	}

	public void updateWorkExperience(final int jobId, 
			final String company, 
			final String city, 
			final String state, 
			final String title,
			final String startDate, 
			final String endDate) {
		String sqlStatement = 
				"UPDATE FN_WORK_EXPERIENCE SET COMPANY = ?, CITY = ?, STATE = ?, TITLE = ?, START_DATE = ?, END_DATE = ? WHERE JOB_ID = ?";
		jdbcTemplateObject.update(sqlStatement, company, city, state, title, startDate, endDate, jobId);
		System.out.println("UPDATED: " + jobId);
	}

	public void deleteWorkExperience(final int id) {
		String sqlStatement = "DELETE FROM FN_WORK_EXPERIENCE WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<WorkExperience> listWorkExperience() {
		String sqlStatement = "SELECT * FROM FN_WORK_EXPERIENCE";
		return jdbcTemplateObject.query(sqlStatement, new WorkExperienceMapper()).stream();
	}

}
