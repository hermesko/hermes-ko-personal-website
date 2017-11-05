package com.hermesko.test;

import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hermesko.jdbc.AwardsJDBCTemplate;
import com.hermesko.jdbc.ContactInfoJDBCTemplate;
import com.hermesko.jdbc.CourseworkJDBCTemplate;
import com.hermesko.jdbc.EducationJDBCTemplate;
import com.hermesko.jdbc.ExtracurricularsJDBCTemplate;
import com.hermesko.model.Awards;
import com.hermesko.model.ContactInfo;
import com.hermesko.model.Coursework;
import com.hermesko.model.Education;
import com.hermesko.model.Extracurriculars;

public class JDBCMainTests {
	
	public static void main(String[] args) {
		JDBCMainTests.testAwardsJDBC();
		JDBCMainTests.testContactInfoJDBC();
		JDBCMainTests.testCourseworkJDBC();
		JDBCMainTests.testEducationJBDC();
		JDBCMainTests.testExtracurricularsJDBC();
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
		
		System.out.println("------Deleting record with ID = " + ffbd.getTitle() + "------");
		extracurricularsJDBCTemplate.deleteExtracurriculars(ffbd.getId());
	}
}
