package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.ProjectDetails;

public class ProjectDetailsMapper implements RowMapper<ProjectDetails> {

	public ProjectDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProjectDetails(rs.getInt("ID"),
				rs.getInt("PROJECT_ID"),
				rs.getString("DETAIL"));
	}
}
