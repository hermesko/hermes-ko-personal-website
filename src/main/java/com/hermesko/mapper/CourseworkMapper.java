package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Coursework;

public class CourseworkMapper implements RowMapper<Coursework>{
	
	public Coursework mapRow(ResultSet rs, int row) throws SQLException {
		return new Coursework(rs.getInt("ID"),
				rs.getInt("SCHOOL_ID"), 
				rs.getString("COURSE"));
	}
}
