package com.hermesko.controller;

import java.util.stream.Collectors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hermesko.jdbc.AwardsJDBCTemplate;
import com.hermesko.jdbc.ContactInfoJDBCTemplate;
import com.hermesko.jdbc.CourseworkJDBCTemplate;
import com.hermesko.jdbc.EducationJDBCTemplate;
import com.hermesko.jdbc.ExtracurricularsJDBCTemplate;
import com.hermesko.jdbc.ProgrammingLanguagesJDBCTemplate;
import com.hermesko.jdbc.ProjectDetailsJDBCTemplate;
import com.hermesko.jdbc.ProjectsJDBCTemplate;
import com.hermesko.jdbc.TechnologiesJDBCTemplate;
import com.hermesko.jdbc.WorkExperienceJDBCTemplate;
import com.hermesko.jdbc.WorkResponsibilitiesJDBCTemplate;

@RestController
@RequestMapping(value = "/resume")
public class ResumeController {

	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	
	ObjectMapper mapper = new ObjectMapper();
    
	@RequestMapping(value = "/awards", method = RequestMethod.GET, produces = "application/json")
	public String getAwards() throws JsonProcessingException {
		AwardsJDBCTemplate awardsJDBCTemplate = (AwardsJDBCTemplate) context.getBean("AwardsJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(awardsJDBCTemplate.listAwards().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/contactInfo", method = RequestMethod.GET, produces = "application/json")
	public String getContactInfo() throws JsonProcessingException {
		ContactInfoJDBCTemplate contactInfoJDBCTemplate = (ContactInfoJDBCTemplate) context.getBean("ContactInfoJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(contactInfoJDBCTemplate.listContactInfo().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/coursework", method = RequestMethod.GET, produces = "application/json")
	public String getCoursework() throws JsonProcessingException {
		CourseworkJDBCTemplate courseworkJDBCTemplate = (CourseworkJDBCTemplate) context.getBean("CourseworkJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(courseworkJDBCTemplate.listCoursework().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/education", method = RequestMethod.GET, produces = "application/json")
	public String getEducation() throws JsonProcessingException {
		EducationJDBCTemplate educationJDBCTemplate = (EducationJDBCTemplate) context.getBean("EducationJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(educationJDBCTemplate.listEducation().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/extracurriculars", method = RequestMethod.GET, produces = "application/json")
	public String getExtracurriculars() throws JsonProcessingException {
		ExtracurricularsJDBCTemplate extracurricularsJDBCTemplate = (ExtracurricularsJDBCTemplate) context.getBean("ExtracurricularsJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(extracurricularsJDBCTemplate.listExtracurriculars().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/programmingLanguages", method = RequestMethod.GET, produces = "application/json")
	public String getProgrammingLanguages() throws JsonProcessingException {
		ProgrammingLanguagesJDBCTemplate programmingLanguagesJDBCTemplate = (ProgrammingLanguagesJDBCTemplate) context.getBean("ProgrammingLanguagesJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(programmingLanguagesJDBCTemplate.listProgrammingLanguages().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/projectDetails", method = RequestMethod.GET, produces = "application/json")
	public String getProjectDetails() throws JsonProcessingException {
		ProjectDetailsJDBCTemplate projectDetailsJDBCTemplate = (ProjectDetailsJDBCTemplate) context.getBean("ProjectDetailsJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(projectDetailsJDBCTemplate.listProjectDetails().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = "application/json")
	public String getProjects() throws JsonProcessingException {
		ProjectsJDBCTemplate projectsJDBCTemplate = (ProjectsJDBCTemplate) context.getBean("ProjectsJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(projectsJDBCTemplate.listProjects().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/technologies", method = RequestMethod.GET, produces = "application/json")
	public String getTechnologies() throws JsonProcessingException {
		TechnologiesJDBCTemplate technologiesJDBCTemplate = (TechnologiesJDBCTemplate) context.getBean("TechnologiesJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(technologiesJDBCTemplate.listTechnologies().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/workExperience", method = RequestMethod.GET, produces = "application/json")
	public String getWorkExperience() throws JsonProcessingException {
		WorkExperienceJDBCTemplate workExperienceJDBCTemplate = (WorkExperienceJDBCTemplate) context.getBean("WorkExperienceJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(workExperienceJDBCTemplate.listWorkExperience().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
	
	@RequestMapping(value = "/workResponsibilities", method = RequestMethod.GET, produces = "application/json")
	public String getWorkResponsibilities() throws JsonProcessingException {
		WorkResponsibilitiesJDBCTemplate workResponsibilitiesJDBCTemplate = (WorkResponsibilitiesJDBCTemplate) context.getBean("WorkResponsibilitiesJDBCTemplate");
		String json = null;
		try {
			json = mapper.writeValueAsString(workResponsibilitiesJDBCTemplate.listWorkResponsibilities().collect(Collectors.toList()));
		} catch (Exception e){
			json = e.getMessage();
		} 
		return json;
	}
}
