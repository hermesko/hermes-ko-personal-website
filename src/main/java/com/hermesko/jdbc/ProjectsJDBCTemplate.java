package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.ProjectsDAO;
import com.hermesko.mapper.ProjectsMapper;
import com.hermesko.model.Projects;

public class ProjectsJDBCTemplate implements ProjectsDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createProjects(final String name, final String purpose, final String startDate, final String endDate) {
		String sqlStatement = "INSERT INTO FN_PROJECTS (NAME, PURPOSE, START_DATE, END_DATE) VALUES (?, ?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement, name, purpose, startDate, endDate);
		System.out.println("INSERTED: " + name + ' ' + purpose + ' ' + startDate + ' ' + endDate);
	}

	public Projects getProjects(final int id) {
		String sqlStatement = "SELECT * FROM FN_PROJECTS WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new ProjectsMapper());
	}

	public void updateProjects(final int projectId, 
			final String name, 
			final String purpose, 
			final String startDate, 
			final String endDate) {
		String sqlStatement = "UPDATE FN_PROJECTS SET NAME = ?, PURPOSE = ?, START_DATE = ?, END_DATE = ? WHERE PROJECT_ID = ?";
		jdbcTemplateObject.update(sqlStatement, name, purpose, startDate, endDate, projectId);
		System.out.println("UPDATED: " + projectId);
	}

	public void deleteProjects(final int id) {
		String sqlStatement = "DELETE FROM FN_PROJECTS WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}
	
	public Stream<Projects> listProjects() {
		String sqlStatement = "SELECT * FROM FN_PROJECTS";
		return jdbcTemplateObject.query(sqlStatement, new ProjectsMapper()).stream();
	}

}
