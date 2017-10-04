INSERT INTO RESUME.FN_CONTACT_INFO(NAME, CITY, STATE, PHONE, EMAIL, GITHUB, LINKEDIN)
	VALUES('Hermes Ko', 'Brooklyn', 'NY', '(917) 838-0400', 'hko6074@gmail.com', 'github.com/hermesko', 'linkedin.com/in/hko6074');

INSERT INTO RESUME.FN_EDUCATION(INSTITUTION, CITY, STATE, DEGREE_TYPE, MAJOR, GPA, LATIN_HONORS, CONFERRAL_DATE)
	VALUES('University at Buffalo, the State University of New York', 'Amherst', 'NY', 'Bachelor of Science', 'Computer Engineering', '3.523', 'Magna Cum Laude', 'May 2017');

INSERT INTO RESUME.FN_AWARDS(SCHOOL_ID, NAME, DATE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Dean''s List', 'Spring 2015');
INSERT INTO RESUME.FN_AWARDS(SCHOOL_ID, NAME, DATE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Dean''s List', 'Fall 2016');
INSERT INTO RESUME.FN_AWARDS(SCHOOL_ID, NAME, DATE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Provost Scholarship', 'Fall 2013 - Spring 2017');

INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Intro to Data Mining');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Software Engineering');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Algorithms for Modern Compute Systems');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Algorithm Analysis & Design');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Data Structures & Algorithms');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Hardware/Software Integrated Systems Design');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Intro to Microprocessors');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Electronic Devices & Circuits');
INSERT INTO RESUME.FN_COURSEWORK(SCHOOL_ID, COURSE)
	VALUES((SELECT SCHOOL_ID FROM RESUME.FN_EDUCATION WHERE INSTITUTION='University at Buffalo, the State University of New York'), 'Circuit Analysis');

INSERT INTO RESUME.FN_WORK_EXPERIENCE(COMPANY, CITY, STATE, TITLE, START_DATE, END_DATE)
	VALUES('AT&T, Inc.', 'Middletown', 'NJ', 'Associate Applications Developer - Software Engineer', 'June 2017', 'Present');
INSERT INTO RESUME.FN_WORK_EXPERIENCE(COMPANY, CITY, STATE, TITLE, START_DATE, END_DATE)
	VALUES('University at Buffalo: Department of Computer Science & Engineering', 'Amherst', 'NY', 'Undergraduate Teaching Assistant (Data Structures & Algorithms)', 'August 2016', 'December 2016');
INSERT INTO RESUME.FN_WORK_EXPERIENCE(COMPANY, CITY, STATE, TITLE, START_DATE, END_DATE)
	VALUES('University at Buffalo: Division of Athletics', 'Amherst', 'NY', 'Office Assistant', 'September 2014', 'May 2016');

INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='AT&T, Inc.'), 'Utilized AngularJS, Java, PostgreSQL, and Spring to implement & maintain features for various web applications.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='AT&T, Inc.'), 'Designed and implemented Java API clients, leveraging the Jackson Databind Library for serializing/deserializing HTTP responses returned from HTTP requests.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='AT&T, Inc.'), 'Leveraged Apache Maven in order to abstract and manage project dependencies common to multiple projects.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='AT&T, Inc.'), 'Utilized Cloudify in order to deploy applications to virtual machines in OpenStack environments, and monitored virtual machine/application accessibility via Consul.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='AT&T, Inc.'), 'Organized and executed various company activities to promote and encourage team bonding.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Department of Computer Science & Engineering'), 'Encouraged student participation by actively answering student inquiries and endorsing student responses on the course Piazza webpage.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Department of Computer Science & Engineering'), 'Provided students the ability to re-visit lecture material by recording, rendering and uploading lecture videos to the course website.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Department of Computer Science & Engineering'), 'Ensured successful and accurate grading of student programming assignments via monitoring of the course auto-grading system.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Department of Computer Science & Engineering'), 'Assessed class strengths and weaknesses via the grading of exams and analysis of exam results.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Division of Athletics'), 'Coordinated the reception and distribution of postage to appropriate offices.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Division of Athletics'), 'Received phone calls, recording messages where appropriate.');
INSERT INTO RESUME.FN_WORK_RESPONSIBILITIES(JOB_ID, RESPONSIBILITY)
	VALUES((SELECT JOB_ID FROM RESUME.FN_WORK_EXPERIENCE WHERE COMPANY='University at Buffalo: Division of Athletics'), 'Maintained proper and efficient operation of office equipment and electronics.');

INSERT INTO RESUME.FN_PROJECTS(NAME, PURPOSE, START_DATE, END_DATE)
	VALUES('Personal Resume Website', 'Personal', 'October 2017', 'Present');
INSERT INTO RESUME.FN_PROJECTS(NAME, PURPOSE, START_DATE, END_DATE)
	VALUES('Wear Where?', 'Academic', 'September 2016', 'December 2016');
INSERT INTO RESUME.FN_PROJECTS(NAME, PURPOSE, START_DATE, END_DATE)
	VALUES('Corporate Product Catalog Application', 'Contract', 'July 2016', 'August 2016');
INSERT INTO RESUME.FN_PROJECTS(NAME, PURPOSE, START_DATE, END_DATE)
	VALUES('Q*Bert Terminal Game', 'Academic', 'April 2016', 'May 2016');

INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Personal Resume Website'), 'Description 1 to be updated');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Personal Resume Website'), 'Description 2 to be updated');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Personal Resume Website'), 'Technologies used to be updated');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Wear Where?'), 'Android application that provides the end-user with various information based on the current weather.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Wear Where?'), 'Provides appropriate apparel suggestions, and weather alerts for road trips and vacation planning.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Wear Where?'), 'Technologies used: Android Studio, Java, JSON, Git, GitHub, Google Directions/Maps/Places API, XML.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Corporate Product Catalog Application'), 'Android application that allows the end-user to search and view various products offered by the company.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Corporate Product Catalog Application'), 'Provides descriptions, prices, and photos of queried products.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Corporate Product Catalog Application'), 'Technologies used: Android Studio, Java, XML.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Q*Bert Terminal Game'), 'A terminal game based on Gottlieb’s Q*Bert®, written entirely in the ARM Assembly Language.');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Q*Bert Terminal Game'), 'Utilizes UART, interrupt, and timer modules (to handle input and gameplay), and GPIO modules (to provide real-time gameplay information via a 7-segment display and various LEDs).');
INSERT INTO RESUME.FN_PROJECT_DETAILS(PROJECT_ID, DETAIL)
	VALUES((SELECT PROJECT_ID FROM RESUME.FN_PROJECTS WHERE NAME='Q*Bert Terminal Game'), 'Technologies used: ARM Assembly, Keil µVision, Embedded Artists NXP LPC2138 Education Board.');

INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('Java');
INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('C++');
INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('Bash');
INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('YAML');
INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('JSON');
INSERT INTO RESUME.FN_PROGRAMMING_LANGUAGES(PROGRAMMING_LANGUAGE)
	VALUES('SQL');
	
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Android Studio');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Apache Maven');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('CodeCloud');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Cloudify');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Git');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('GitHub');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Eclipse');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Keil µVision');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Linux');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Multisim');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Microsoft Office');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('PostgreSQL');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Spring');
INSERT INTO RESUME.FN_TECHNOLOGIES(TECHNOLOGY)
	VALUES('Windows');
	
INSERT INTO RESUME.FN_EXTRACURRICULARS(TITLE, START_DATE, END_DATE)
	VALUES('NY Chinese Freemasons Athletic Club Member', 'May 2016', 'Present');
INSERT INTO RESUME.FN_EXTRACURRICULARS(TITLE, START_DATE, END_DATE)
	VALUES('UB Asian Amerian Student Union', 'September 2014', 'May 2017');
INSERT INTO RESUME.FN_EXTRACURRICULARS(TITLE, START_DATE, END_DATE)
	VALUES('UB Intramural Volleyball Team Captain', 'September 2013', 'May 2017');
INSERT INTO RESUME.FN_EXTRACURRICULARS(TITLE, START_DATE, END_DATE)
	VALUES('PSAL Boys Varsity Bowling Team Captain', 'September 2011', 'November 2012');