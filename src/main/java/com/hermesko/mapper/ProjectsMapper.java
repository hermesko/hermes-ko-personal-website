package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Projects;

public class ProjectsMapper implements RowMapper<Projects> {

	public Projects mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Projects(rs.getInt("PROJECT_ID"),
				rs.getString("NAME"),
				rs.getString("PURPOSE"),
				rs.getString("START_DATE"),
				rs.getString("END_DATE"));
	}
}
