package com.hermesko.test;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hermesko.jdbc.AwardsJDBCTemplate;
import com.hermesko.jdbc.EducationJDBCTemplate;
import com.hermesko.model.Awards;
import com.hermesko.model.Education;

public class MainApp {
	
	public static void main(String[] args) {
		MainApp.testEducationJBDC();
		MainApp.testAwardsJDBC();
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
		
		award.forEach(a -> System.out.println("SCHOOL_ID: " + a.getSchoolId() + 
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
}
