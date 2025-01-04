#Job Portal Application#
This is a Job Portal Web Application built using Spring Boot, Java, JSP, Spring Data JPA, and MySQL/PostgreSQL. The platform allows users to create accounts, log in, and apply for job listings. Employers can post job openings for users to browse and apply. The application also uses Spring Security for secure login and authentication.

Features
User Authentication:

Users can register, log in, and update their profiles.
Passwords are hashed using BCryptPasswordEncoder for enhanced security.
Job Listings:

Employers can post job openings.
Users can browse available jobs and apply to them.
User Dashboard:

After logging in, users can view their profile, update details, and see job applications.
Admin Panel:

Admins can manage users and job posts.
Spring Boot & Spring Data JPA:

Backend built with Spring Boot for ease of development and integration.
Spring Data JPA is used for database interactions.
JSP Frontend:

The front-end is developed using JSP (JavaServer Pages) to handle dynamic page rendering.
Spring Security:

The application integrates Spring Security for user authentication and authorization.
MySQL/PostgreSQL Database:

MySQL/PostgreSQL used for storing user, job, and other relevant data.
The database configuration can be easily updated in the application.properties file.
Technologies Used
Java (Spring Boot)
Spring Data JPA
JSP (JavaServer Pages)
MySQL/PostgreSQL
Spring Security for authentication
Maven for project dependency management
BCrypt for password encryption
Installation
Prerequisites
Java (JDK 11 or above) installed.
Maven for building and managing dependencies.
MySQL or PostgreSQL installed for database management.
Git for cloning the repository.
Steps to Run Locally
Clone the Repository:

bash
Copy code
git clone https://github.com/imcoder44/job-portal.git
cd job-portal
Set Up the Database:

Create a MySQL or PostgreSQL database.

In MySQL:

sql
Copy code
CREATE DATABASE job_portal;
Update your application.properties file with the correct database credentials:

For MySQL:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/job_portal
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
For PostgreSQL:

properties
Copy code
spring.datasource.url=jdbc:postgresql://localhost:5432/job_portal
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
Build the Application:

In the terminal, navigate to the project directory and run:

bash
Copy code
mvn clean install
Run the Application:

Once the build is successful, run the application using:

bash
Copy code
mvn spring-boot:run
Access the Application:

Open your browser and navigate to http://localhost:8080.
You can now register as a user or employer and interact with the job portal.
Directory Structure
css
Copy code
job-portal/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── jobportal/
│   │   │   │       ├── controller/
│   │   │   │       ├── model/
│   │   │   │       ├── repository/
│   │   │   │       ├── service/
│   │   │   │       └── JobPortalApplication.java
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/
│   │               ├── index.jsp
│   │               ├── login.jsp
│   │               ├── register.jsp
│   │               └── dashboard.jsp
├── pom.xml
└── README.md
Contributing
Feel free to fork this project and contribute to it by:

Reporting bugs
Suggesting improvements
Opening pull requests for new features
License
This project is licensed under the MIT License - see the LICENSE file for details.
