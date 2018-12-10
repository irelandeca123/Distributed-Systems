package gmit.ie.Database;

import java.sql.Connection;
import java.sql.DriverManager;

//Database Connection Class
public class DB_Connection {
	
	//public method to create the connection between mySQL and Java
	public static void main(String[] args) {
		DB_Connection obj_DB_Connection=new DB_Connection();
		Connection connection=null;
		connection=obj_DB_Connection.get_connection();
		System.out.println(connection);
	}
	
	public Connection get_connection(){
		Connection connection=null;
		//class for name is the driver to look for , in my situation i will be using jar to connect 
		//mySQL to java and then settings for it to connect
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/carhire","root","");
		}catch (Exception e) {
		//if any error catch it and print the problem
			System.out.println(e);
		}
		
		//return the connection
		return connection;
	}
}