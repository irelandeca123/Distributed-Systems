# A RESTful Car Hire Booking System 
## Distributed-Systems Project 2018-2019
JAX-RS/Jersey, Java RMI and JAXB frameworks to develop a simple Car Hire Booking System. 
A Web Client page should provide users with the ability to Create/Modify/Update/Delete
bookings for a specific vehicle for a given set of dates. The Web Client will interact with a RESTful JAX-RS
Web Service for bookings which is deployed on Apache Tomcat Server. The RESTful Web Service will act as
a RMI client to a RMI Database Server which will handle persistence.

## How to use my project
Make sure you have the following:
- MySQL Connector/J installed if you don't you can download it from the link below.
> https://dev.mysql.com/downloads/connector/j/5.1.html
- MySQL installed & Wamp 
> http://www.wampserver.com/en/
> https://www.mysql.com/downloads/
- MYSQL table:
> CREATE TABLE cardatabase (
     id MEDIUMINT NOT NULL AUTO_INCREMENT,
     name CHAR(30) NOT NULL,
  	phoneNumber int,
  	city CHAR(30) NOT NULL,
  	car CHAR(30) NOT NULL ,
  	date DATE ,
     PRIMARY KEY (id)
);
- TomCat 9.0: 
> https://tomcat.apache.org/download-90.cgi
- Eclipse IDE
> https://www.eclipse.org/ide/
### Steps
- 1: Clone my project from this repository.
- 2: Open it with Eclipse IDE (File => Open Projects From File System & navigate to the folder where you cloned this repository).
- 3: Right click on the project and Run as => Run on server.
- 4: Register using the form (html post).
- 5: Display database using (html get).
