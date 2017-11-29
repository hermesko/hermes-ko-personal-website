package com.hermesko.jdbc;

import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hermesko.dao.ProgrammingLanguagesDAO;
import com.hermesko.mapper.ProgrammingLanguagesMapper;
import com.hermesko.model.ProgrammingLanguages;

public class ProgrammingLanguagesJDBCTemplate implements ProgrammingLanguagesDAO {

	@SuppressWarnings("unused")
	private DataSource ds;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(final DataSource ds) {
		this.ds = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	public void createProgrammingLanguages(final String programmingLanguage) {
		String sqlStatement = "INSERT INTO FN_PROGRAMMING_LANGUAGES (PROGRAMMING_LANGUAGE) values (?)";
		jdbcTemplateObject.update(sqlStatement, programmingLanguage);
		System.out.println("INSERTED: " + programmingLanguage);
	}

	public ProgrammingLanguages getProgrammingLanguages(final int id) {
		String sqlStatement = "SELECT * FROM FN_PROGRAMMING_LANGUAGES WHERE ID = ?";
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] {id}, new ProgrammingLanguagesMapper());	
	}

	public void updateProgrammingLanguages(final int id, final String programmingLanguage) {
		String sqlStatement = "UPDATE FN_PROGRAMMING_LANGUAGES SET PROGRAMMING_LANGUAGE = ? WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, programmingLanguage, id);
		System.out.println("UPDATED: " + id);
	}

	public void deleteProgrammingLanguages(final int id) {
		String sqlStatement = "DELETE FROM FN_PROGRAMMING_LANGUAGES WHERE ID = ?";
		jdbcTemplateObject.update(sqlStatement, id);
		System.out.println("DELETED: " + id);
	}

	public Stream<ProgrammingLanguages> listProgrammingLanguages() {
		String sqlStatement = "SELECT * FROM FN_PROGRAMMING_LANGUAGES";
		return jdbcTemplateObject.query(sqlStatement, new ProgrammingLanguagesMapper()).stream();
	}

}
