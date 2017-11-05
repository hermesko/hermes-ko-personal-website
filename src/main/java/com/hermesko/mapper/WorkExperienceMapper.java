package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.WorkExperience;

public class WorkExperienceMapper implements RowMapper<WorkExperience> {

	public WorkExperience mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new WorkExperience(rs.getInt("JOB_ID"),
				rs.getString("COMPANY"),
				rs.getString("CITY"),
				rs.getString("STATE"),
				rs.getString("TITLE"),
				rs.getString("START_DATE"),
				rs.getString("END_DATE"));
	}
}
