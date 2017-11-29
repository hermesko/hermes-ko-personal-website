package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.ProgrammingLanguages;

public class ProgrammingLanguagesMapper implements RowMapper<ProgrammingLanguages> {

	public ProgrammingLanguages mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ProgrammingLanguages(rs.getInt("ID"),
				rs.getString("PROGRAMMING_LANGUAGE"));
	}
}
