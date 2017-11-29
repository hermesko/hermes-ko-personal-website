package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.WorkResponsibilitiesDAO;
import com.hermesko.mapper.WorkResponsibilitiesMapper;
import com.hermesko.model.WorkResponsibilities;

public class WorkResponsibilitiesJDBCTemplate implements WorkResponsibilitiesDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createWorkResponsibilities(final int jobId, final String responsibility) {
		String sqlStatement = "INSERT INTO FN_WORK_RESPONSIBILITIES (JOB_ID, RESPONSIBILITY) VALUES (?, ?)";
		jdbcTemplateObject.update(sqlStatement, jobId, responsibility);
		System.out.println("INSERTED: " + jobId + ' ' + responsibility);
	}

	public WorkResponsibilities getWorkResponsibilities(final int id) {
		String sqlStatement = "SELECT * FROM FN_WORK_RESPONSIBILITIES WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new WorkResponsibilitiesMapper());
	}

	public void updateWorkResponsibilities(final int id, final int jobId, final String responsibility) {
		String sqlStatement = "UPDATE FN_WORK_RESPONSIBILITIES SET JOB_ID = ?, RESPONSIBILITY = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, jobId, responsibility, id);
		System.out.println("UPDATED: " + id);	
	}

	public void deleteWorkResponsibilities(final int id) {
		String sqlStatement = "DELETE FROM FN_WORK_RESPONSIBILITIES WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<WorkResponsibilities> listWorkResponsibilities() {
		String sqlStatement = "SELECT * FROM FN_WORK_RESPONSIBILITIES";
		return jdbcTemplateObject.query(sqlStatement, new WorkResponsibilitiesMapper()).stream();
	}

}
