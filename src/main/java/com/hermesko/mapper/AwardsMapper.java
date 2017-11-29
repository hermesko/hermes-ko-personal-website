package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Awards;

public class AwardsMapper implements RowMapper<Awards> {

	public Awards mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Awards(rs.getInt("ID"),
				rs.getInt("SCHOOL_ID"),
				rs.getString("NAME"),
				rs.getString("DATE"));
	}
}
