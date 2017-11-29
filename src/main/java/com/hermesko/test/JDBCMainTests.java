package com.hermesko.test;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
import com.hermesko.model.Awards;
import com.hermesko.model.ContactInfo;
import com.hermesko.model.Coursework;
import com.hermesko.model.Education;
import com.hermesko.model.Extracurriculars;
import com.hermesko.model.ProgrammingLanguages;
import com.hermesko.model.ProjectDetails;
import com.hermesko.model.Projects;
import com.hermesko.model.Technologies;
import com.hermesko.model.WorkExperience;
import com.hermesko.model.WorkResponsibilities;

public class JDBCMainTests {
	
	public static void main(String[] args) {
		/*
		JDBCMainTests.testAwardsJDBC();
		JDBCMainTests.testContactInfoJDBC();
		JDBCMainTests.testCourseworkJDBC();
		JDBCMainTests.testEducationJBDC();
		JDBCMainTests.testExtracurricularsJDBC();
		JDBCMainTests.testProgrammingLanguagesJDBC();
		JDBCMainTests.testProjectDetailsJDBC();
		JDBCMainTests.testProjectsJDBC();
		JDBCMainTests.testTechnologiesJDBC();
		JDBCMainTests.testWorkExperienceJDBC();
		*/
		JDBCMainTests.testWorkResponsibilitiesJDBC();
	}

	private static void testEducationJBDC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		EducationJDBCTemplate educationJDBCTemplate = (EducationJDBCTemplate) context.getBean("EducationJDBCTemplate");
		
		System.out.println("------Records Creation------");
		educationJDBCTemplate.createEducation("BTHS", "Brooklyn", "NY", "High School Diploma", "Biological Sciences", "3.72", "N/A", "June 2013");
		
		System.out.println("------Listing Records------");
		Stream<Education> education = educationJDBCTemplate.listEducation();
		
		education.forEach(e -> System.out.println("SCHOOL_ID: " + e.getSchoolId() + 
													" INSTITUTION: " + e.getInstitution() + 
													" CITY: " + e.getCity() +
													" STATE: " + e.getState() + 
													" DEGREE_TYPE: " + e.getDegreeType() + 
													" MAJOR: " + e.getMajor() + 
													" GPA: " + e.getGpa() + 
													" LATIN_HUNORS: " + e.getLatinHonors() +
													" CONFERRAL_DATE: " + e.getConferralDate()));
		
		education = educationJDBCTemplate.listEducation();
		Education bths = education.filter(e -> e.getInstitution().equals("BTHS")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + bths.getSchoolId() + "------");
		educationJDBCTemplate.updateEducation(bths.getSchoolId(), 
				"Brooklyn Technical High School", 
				bths.getCity(), 
				bths.getState(), 
				bths.getDegreeType(), 
				bths.getMajor(), 
				bths.getGpa(), 
				bths.getLatinHonors(), 
				bths.getConferralDate());
		
		System.out.println("------Deleting record with ID = " + bths.getSchoolId() + "------");
		educationJDBCTemplate.deleteEducation(bths.getSchoolId());
	}
	
	private static void testAwardsJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		AwardsJDBCTemplate awardsJDBCTemplate = (AwardsJDBCTemplate) context.getBean("AwardsJDBCTemplate");
		
		System.out.println("------Records Creation------");
		awardsJDBCTemplate.createAward(1, "Valedectorian", "May 2017");
		
		System.out.println("------Listing Records------");
		Stream<Awards> award = awardsJDBCTemplate.listAwards();
		
		award.forEach(a -> System.out.println("ID: " + a.getId() +
													" SCHOOL_ID: " + a.getSchoolId() + 
													" NAME: " + a.getName() +
													" DATE: " + a.getDate()));
		
		award = awardsJDBCTemplate.listAwards();
		Awards valadectorian = award.filter(a -> a.getName().equals("Valedectorian")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + valadectorian.getId() + "------");
		awardsJDBCTemplate.updateAward(valadectorian.getId(), 
				valadectorian.getSchoolId(), 
				"Summa Cum Laude",
				valadectorian.getDate());
		
		System.out.println("------Deleting record with ID = " + valadectorian.getId() + "------");
		awardsJDBCTemplate.deleteAward(valadectorian.getId());
	}
	
	private static void testContactInfoJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ContactInfoJDBCTemplate contactInfoJDBCTemplate = (ContactInfoJDBCTemplate) context.getBean("ContactInfoJDBCTemplate");
		
		System.out.println("------Records Creation------");
		contactInfoJDBCTemplate.createContactInfo("Carmelo Anthony",
				"New York",
				"NY",
				"UNKNOWN",
				"UNKNOWN",
				"UNKNOWN",
				"UNKNOWN");	
		
		System.out.println("------Listing Records------");
		Stream<ContactInfo> contactInfo = contactInfoJDBCTemplate.listContactInfo();
		
		contactInfo.forEach(c -> System.out.println("ID: " + c.getId() +
													" NAME: " + c.getName() + 
													" CITY: " + c.getCity() +
													" STATE: " + c.getState() +
													" PHONE: " + c.getPhone() +
													" EMAIL: " + c.getEmail() +
													" GITHUB: " + c.getGithub() +
													" LINKEDIN: " + c.getLinkedin()));
		
		contactInfo = contactInfoJDBCTemplate.listContactInfo();
		ContactInfo melo = contactInfo.filter(c -> c.getName().equals("Carmelo Anthony")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + melo.getId() + "------");
		contactInfoJDBCTemplate.updateContactInfo(melo.getId(), 
				melo.getName(), 
				"Oklahoma City",
				"OK", 
				melo.getPhone(),
				melo.getEmail(),
				melo.getGithub(),
				melo.getLinkedin());
		
		System.out.println("------Deleting record with ID = " + melo.getId() + "------");
		contactInfoJDBCTemplate.deleteContactInfo(melo.getId());
	}
	
	private static void testCourseworkJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		CourseworkJDBCTemplate courseworkJDBCTemplate = (CourseworkJDBCTemplate) context.getBean("CourseworkJDBCTemplate");
		
		System.out.println("------Records Creation------");
		courseworkJDBCTemplate.createCoursework(1, "Computer Architecture");	
		
		System.out.println("------Listing Records------");
		Stream<Coursework> coursework = courseworkJDBCTemplate.listCoursework();
		
		coursework.forEach(c -> System.out.println("ID: " + c.getId() +
													" SCHOOL_ID: " + c.getSchoolId() + 
													" COURSE: " + c.getCourse()));
		
		coursework = courseworkJDBCTemplate.listCoursework();
		Coursework cse490 = coursework.filter(c -> c.getCourse().equals("Computer Architecture")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + cse490.getId() + "------");
		courseworkJDBCTemplate.updateCoursework(cse490.getId(), 
				cse490.getSchoolId(),
				"Theory of Computation");
		
		System.out.println("------Deleting record with ID = " + cse490.getId() + "------");
		courseworkJDBCTemplate.deleteCoursework(cse490.getId());
	}
	
	private static void testExtracurricularsJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ExtracurricularsJDBCTemplate extracurricularsJDBCTemplate = (ExtracurricularsJDBCTemplate) context.getBean("ExtracurricularsJDBCTemplate");
		
		System.out.println("------Records Creation------");
		extracurricularsJDBCTemplate.createExtracurriculars("Flex Force Bagel Day", "October 2017", "Present");
		
		System.out.println("------Listing Records------");
		Stream<Extracurriculars> extracurriculars = extracurricularsJDBCTemplate.listExtracurriculars();
		
		extracurriculars.forEach(e -> System.out.println("ID: " + e.getId() +
													" TITLE: " + e.getTitle() + 
													" START_DATE: " + e.getStartDate() +
													" END_DATE: " + e.getEndDate()));
		
		extracurriculars = extracurricularsJDBCTemplate.listExtracurriculars();
		Extracurriculars ffbd = extracurriculars.filter(e -> e.getTitle().equals("Flex Force Bagel Day")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + ffbd.getId() + "------");
		extracurricularsJDBCTemplate.updateExtracurriculars(ffbd.getId(), 
				"Flex Force Bagel Day", 
				"September 2017", 
				ffbd.getEndDate());
		
		System.out.println("------Deleting record with ID = " + ffbd.getId() + "------");
		extracurricularsJDBCTemplate.deleteExtracurriculars(ffbd.getId());
	}
	
	private static void testProgrammingLanguagesJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ProgrammingLanguagesJDBCTemplate programmingLanguagesJDBCTemplate = (ProgrammingLanguagesJDBCTemplate) context.getBean("ProgrammingLanguagesJDBCTemplate");
		
		System.out.println("------Records Creation------");
		programmingLanguagesJDBCTemplate.createProgrammingLanguages("Groovy");
		
		System.out.println("------Listing Records------");
		Stream<ProgrammingLanguages> programmingLanguages = programmingLanguagesJDBCTemplate.listProgrammingLanguages();
		
		programmingLanguages.forEach(p -> System.out.println("ID: " + p.getId() +
													" PROGRAMMING_LANGUAGE: " + p.getProgrammingLanguage()));
		
		programmingLanguages = programmingLanguagesJDBCTemplate.listProgrammingLanguages();
		ProgrammingLanguages programmingLanguage = programmingLanguages.filter(p -> p.getProgrammingLanguage().equals("Groovy")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + programmingLanguage.getId() + "------");
		programmingLanguagesJDBCTemplate.updateProgrammingLanguages(programmingLanguage.getId(), 
				"Haskell");
		
		System.out.println("------Deleting record with ID = " + programmingLanguage.getId() + "------");
		programmingLanguagesJDBCTemplate.deleteProgrammingLanguages(programmingLanguage.getId());
	}
	
	private static void testProjectDetailsJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ProjectDetailsJDBCTemplate projectDetailsJDBCTemplate = (ProjectDetailsJDBCTemplate) context.getBean("ProjectDetailsJDBCTemplate");
		
		System.out.println("------Records Creation------");
		projectDetailsJDBCTemplate.createProjectDetails(1, "Implemented DAO Objects, Mappers, and Models for JDBC Access.");
		
		System.out.println("------Listing Records------");
		Stream<ProjectDetails> projectDetails = projectDetailsJDBCTemplate.listProjectDetails();
		
		projectDetails.forEach(p -> System.out.println("ID: " + p.getId() +
													" PROJECT_ID: " + p.getProjectId() + 
													" DETAIL: " + p.getDetail()));
		
		projectDetails = projectDetailsJDBCTemplate.listProjectDetails();
		ProjectDetails projectDetail = projectDetails.filter(p -> p.getDetail().equals("Implemented DAO Objects, Mappers, and Models for JDBC Access.")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + projectDetail.getId() + "------");
		projectDetailsJDBCTemplate.updateProjectDetails(projectDetail.getId(), 
				projectDetail.getProjectId(), "Used AngularJS to create a front-end web application.");
		
		System.out.println("------Deleting record with ID = " + projectDetail.getId() + "------");
		projectDetailsJDBCTemplate.deleteProjectDetails(projectDetail.getId());
	}

	private static void testProjectsJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ProjectsJDBCTemplate projectsJDBCTemplate = (ProjectsJDBCTemplate) context.getBean("ProjectsJDBCTemplate");
		
		System.out.println("------Records Creation------");
		projectsJDBCTemplate.createProjects("Angular 2 Web Application", "Personal", "October 2017", "Present");
		
		System.out.println("------Listing Records------");
		Stream<Projects> projects = projectsJDBCTemplate.listProjects();
		
		projects.forEach(p -> System.out.println("NAME: " + p.getName() + 
													" PURPOSE: " + p.getPurpose() + 
													" START_DATE: " + p.getStartDate() +
													" END_DATE: " + p.getEndDate()));
		
		projects = projectsJDBCTemplate.listProjects();
		Projects angularWebApp = projects.filter(p -> p.getName().equals("Angular 2 Web Application")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + angularWebApp.getProjectId() + "------");
		projectsJDBCTemplate.updateProjects(angularWebApp.getProjectId(), 
				"Angular 4 Web Application", 
				angularWebApp.getPurpose(), 
				angularWebApp.getStartDate(), 
				angularWebApp.getEndDate());
		
		System.out.println("------Deleting record with ID = " + angularWebApp.getProjectId() + "------");
		projectsJDBCTemplate.deleteProjects(angularWebApp.getProjectId());
	}
	
	private static void testTechnologiesJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		TechnologiesJDBCTemplate technologiesJDBCTemplate = (TechnologiesJDBCTemplate) context.getBean("TechnologiesJDBCTemplate");
		
		System.out.println("------Records Creation------");
		technologiesJDBCTemplate.createTechnologies("Angular 4");
		
		System.out.println("------Listing Records------");
		Stream<Technologies> technologies = technologiesJDBCTemplate.listTechnologies();
		
		technologies.forEach(t -> System.out.println("TECHNOLOGY: " + t.getTechnology()));
		
		technologies = technologiesJDBCTemplate.listTechnologies();
		Technologies angular4 = technologies.filter(t -> t.getTechnology().equals("Angular 4")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + angular4.getId() + "------");
		technologiesJDBCTemplate.updateTechnologies(angular4.getId(), "Groovy");
		
		System.out.println("------Deleting record with ID = " + angular4.getId() + "------");
		technologiesJDBCTemplate.deleteTechnologies(angular4.getId());
	}
	
	private static void testWorkExperienceJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		WorkExperienceJDBCTemplate workExperienceJDBCTemplate = (WorkExperienceJDBCTemplate) context.getBean("WorkExperienceJDBCTemplate");
		
		System.out.println("------Records Creation------");
		workExperienceJDBCTemplate.createWorkExperience("Google", "Mountain View", "CA", "Lead Software Engineer", "June 2020", "Present");
		
		System.out.println("------Listing Records------");
		Stream<WorkExperience> workExperience = workExperienceJDBCTemplate.listWorkExperience();
		
		workExperience.forEach(wE -> System.out.println("COMPANY: " + wE.getCompany() + 
				" CITY: " + wE.getCity() +
				" STATE: " + wE.getState() + 
				" TITLE: " + wE.getTitle() + 
				" START_DATE: " + wE.getStartDate() + 
				" END_DATE: " + wE.getEndDate()));
		
		workExperience = workExperienceJDBCTemplate.listWorkExperience();
		WorkExperience capitalOne = workExperience.filter(wE -> wE.getStartDate().equals("June 2020")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + capitalOne.getJobId() + "------");
		workExperienceJDBCTemplate.updateWorkExperience(capitalOne.getJobId(), 
				"Capital One", 
				"New York", 
				"NY", 
				"Master Software Engineer", 
				capitalOne.getStartDate(), 
				capitalOne.getEndDate());
		
		System.out.println("------Deleting record with ID = " + capitalOne.getJobId() + "------");
		workExperienceJDBCTemplate.deleteWorkExperience(capitalOne.getJobId());
	}
	
	private static void testWorkResponsibilitiesJDBC() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		WorkResponsibilitiesJDBCTemplate workResponsibilitiesJDBCTemplate = (WorkResponsibilitiesJDBCTemplate) context.getBean("WorkResponsibilitiesJDBCTemplate");
		
		System.out.println("------Records Creation------");
		workResponsibilitiesJDBCTemplate.createWorkResponsibilities(1, "Mentor new hires");
		
		System.out.println("------Listing Records------");
		Stream<WorkResponsibilities> workResponsibilities = workResponsibilitiesJDBCTemplate.listWorkResponsibilities();
		
		workResponsibilities.forEach(wR -> System.out.println("ID: " + wR.getId() + 
				" JOB_ID: " + wR.getJobId() +
				" RESPONSIBILITY: " + wR.getResponsibility()));
		
		workResponsibilities = workResponsibilitiesJDBCTemplate.listWorkResponsibilities();
		WorkResponsibilities labs = workResponsibilities.filter(wR -> wR.getResponsibility().equals("Mentor new hires")).findFirst().get();
		
		System.out.println("------Updating record with ID = " + labs.getId() + "------");
		workResponsibilitiesJDBCTemplate.updateWorkResponsibilities(labs.getId(), 
				labs.getJobId(), 
				"Support AT&T Labs organization");
		
		System.out.println("------Deleting record with ID = " + labs.getId() + "------");
		workResponsibilitiesJDBCTemplate.deleteWorkResponsibilities(labs.getId());
	}
}
