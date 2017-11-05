package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.Technologies;

public class TechnologiesMapper implements RowMapper<Technologies> {

	public Technologies mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Technologies(rs.getInt("ID"),
				rs.getString("TECHNOLOGY"));
	}
}
