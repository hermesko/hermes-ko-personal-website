package com.hermesko.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hermesko.model.ContactInfo;

public class ContactInfoMapper implements RowMapper<ContactInfo>{

	public ContactInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new ContactInfo(rs.getInt("ID"),
				rs.getString("NAME"),
				rs.getString("CITY"),
				rs.getString("STATE"),
				rs.getString("PHONE"),
				rs.getString("EMAIL"),
				rs.getString("GITHUB"),
				rs.getString("LINKEDIN"));
	}
}
