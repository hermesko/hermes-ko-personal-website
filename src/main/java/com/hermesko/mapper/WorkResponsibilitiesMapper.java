package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.WorkResponsibilities;

public class WorkResponsibilitiesMapper implements RowMapper<WorkResponsibilities> {

	public WorkResponsibilities mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new WorkResponsibilities(rs.getInt("ID"),
				rs.getInt("JOB_ID"),
				rs.getString("RESPONSIBILITY"));
	}
}
