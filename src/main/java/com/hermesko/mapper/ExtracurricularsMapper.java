package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Extracurriculars;

public class ExtracurricularsMapper implements RowMapper<Extracurriculars> {

	public Extracurriculars mapRow(ResultSet rs, int row) throws SQLException {
		return new Extracurriculars(rs.getInt("ID"),
				rs.getString("TITLE"),
				rs.getString("START_DATE"),
				rs.getString("END_DATE"));
	}
}
