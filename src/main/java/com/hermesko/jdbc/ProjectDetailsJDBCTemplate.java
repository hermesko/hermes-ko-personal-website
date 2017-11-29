package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.ProjectDetailsDAO;
import com.hermesko.mapper.ProjectDetailsMapper;
import com.hermesko.model.ProjectDetails;

public class ProjectDetailsJDBCTemplate implements ProjectDetailsDAO{

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createProjectDetails(final int projectId, final String detail) {
		String sqlStatement = "INSERT INTO FN_PROJECT_DETAILS (PROJECT_ID, DETAIL) VALUES (?, ?)";
		jdbcTemplateObject.update(sqlStatement, projectId, detail);
		System.out.println("INSERTED: " + projectId + ' ' + detail);
	}

	public ProjectDetails getProjectDetails(final int id) {
		String sqlStatement = "SELECT * FROM FN_PROJECT_DETAILS WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new ProjectDetailsMapper());
	}

	public void updateProjectDetails(final int id, final int projectId, final String detail) {
		String sqlStatement = "UPDATE FN_PROJECT_DETAILS SET PROJECT_ID = ?, DETAIL = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, projectId, detail, id);
		System.out.println("UPDATED: " + id);
	}

	public void deleteProjectDetails(final int id) {
		String sqlStatement = "DELETE FROM FN_PROJECT_DETAILS WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<ProjectDetails> listProjectDetails() {
		String sqlStatement = "SELECT * FROM FN_PROJECT_DETAILS";
		return jdbcTemplateObject.query(sqlStatement,  new ProjectDetailsMapper()).stream();
	}

}
