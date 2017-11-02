package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Education;

public class EducationMapper implements RowMapper<Education>{

	public Education mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Education(rs.getInt("SCHOOL_ID"),
								rs.getString("INSTITUTION"),
								rs.getString("CITY"),
								rs.getString("STATE"),
								rs.getString("DEGREE_TYPE"),
								rs.getString("MAJOR"),
								rs.getString("GPA"),
								rs.getString("LATIN_HONORS"),
								rs.getString("CONFERRAL_DATE"));
	}
}
