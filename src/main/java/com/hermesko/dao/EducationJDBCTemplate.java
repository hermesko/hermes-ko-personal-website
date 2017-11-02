package com.hermesko.dao;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.mapper.EducationMapper;
import com.hermesko.model.Education;

public class EducationJDBCTemplate implements EducationDAO{

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createEducation(String institution, 
								String city,
								String state,
								String degreeType,
								String major,
								String gpa,
								String latinHonors,
								String conferralDate) {
		String sqlStatement = 
				"INSERT INTO FN_EDUCATION (INSTITUTION, CITY, STATE, DEGREE_TYPE, MAJOR, GPA, LATIN_HONORS, CONFERRAL_DATE) values (?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(sqlStatement,
				institution, city, state, degreeType, major, gpa, latinHonors, conferralDate);
		System.out.println("INSERTED: " + institution + ' ' + city + ' ' + state + ' ' + degreeType + ' ' + major + ' ' + gpa + ' ' + latinHonors + ' ' + conferralDate);
	}

	public Education getEducation(int schoolId) {
		String sqlStatement =
				"SELECT * FROM FN_EDUCATION WHERE SCHOOL_ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {schoolId}, new EducationMapper());
	}

	public void updateEducation(int schoolId, 
								String institution, 
								String city,
								String state,
								String degreeType,
								String major,
								String gpa,
								String latinHonors,
								String conferralDate) {
		String sqlStatement = 
				"UPDATE FN_EDUCATION SET INSTITUTION = ?, CITY = ?, STATE = ?, DEGREE_TYPE = ?, MAJOR = ?, GPA = ?, LATIN_HONORS = ?, CONFERRAL_DATE = ? WHERE SCHOOL_ID = ?";
		jdbcTemplateObject.update(sqlStatement, institution, city, state, degreeType, major, gpa, latinHonors, conferralDate, schoolId);
		System.out.println("UPDATED: " + schoolId);
	}

	public void deleteEducation(int schoolId) {
		String sqlStatement = "DELETE FROM FN_EDUCATION WHERE SCHOOL_ID = ?";
		jdbcTemplateObject.update(sqlStatement, schoolId);
		System.out.println("DELETED: " + schoolId);
	}

	public Stream<Education> listEducation() {
		String sqlStatement = "SELECT * FROM FN_EDUCATION";
		return jdbcTemplateObject.query(sqlStatement, new EducationMapper()).stream();
	}
}
