package gmit.ie.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gmit.ie.DistributedProject.Customer;

public class DAO {
	//Creates connection with the database
	DB_Connection obj_DB_Connection=new DB_Connection();
	Connection connection=obj_DB_Connection.get_connection();

	
// List of all customer reads them one by one and stores them into the customer class 
public List<Customer> getAllCustomers(){

		//Creates a list of customers in array, selects query in mysql selecting the whole database
		List<Customer> customers=new ArrayList<Customer>();
		try {
			PreparedStatement ps= connection.prepareStatement("select * from cardatabase");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Customer customer=new Customer();
				customer.setId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setPhoneNumber(rs.getInt(3));
				customer.setCity(rs.getString(4));						
				customer.setCountry(rs.getString(5));	
				customer.setCar(rs.getString(6));
				
				customers.add(customer);
			
			}
			//closes connection and if any error prints it
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customers;
}
	
//method for getting customer 
public Customer getCustomer(String name){
	Customer customer= new Customer();
	
	//try statement , connecting and executing a mysql query to select from the table (cardatabase) where the name is
	//depending on user input (?)
	try {
		PreparedStatement ps= connection.prepareStatement("select * from cardatabase where name=?");
		ps.setString(1, name );
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			
			customer.setId(rs.getInt(1));
			customer.setName(rs.getString(2));
			customer.setPhoneNumber(rs.getInt(3));
			customer.setCity(rs.getString(4));
			customer.setCountry(rs.getString(5));
			customer.setCar(rs.getString(6));
			customer.setDate(rs.getString(7));	
			
		}
		//closes the connection and catch statement if it goes wrong and returns customer
		rs.close();
		connection.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return customer;
}

//adding customer method throwing sql exception
public Customer addCustomer(Customer customer) throws SQLException{

	//Sql statement inserting details into the table as provided by user 
	PreparedStatement ps=connection.prepareStatement("insert into  cardatabase(name,phoneNumber,city,country,car) values(?,?,?,?,?);");
	
	//sets the variables to user input
	ps.setString(1,customer.getName());
	ps.setInt(2, customer.getPhoneNumber());
	ps.setString(3, customer.getCity());
	ps.setString(4, customer.getCountry());
	ps.setString(5,customer.getCar());	
	
	//displays the status , closes the connection and returns customer
	int status=ps.executeUpdate();
	System.out.println(status);
	ps.close();
	connection.close();
	return customer;
}
	
	//update customer method 
	public int updateCustomer(Customer customer) throws SQLException{
	if(customer.getId()<0) 
		return 0;
	else{
		
	//SQL statement to update the table with the given inputs phonenumber , city , car etc..	
	PreparedStatement ps=connection.prepareStatement("update cardatabase set phoneNumber=?, city=?, car=?, date=?  where name=?");
	//Assigns each variable in customer class
	ps.setInt(1, customer.getPhoneNumber());
	ps.setString(2, customer.getCity());
	ps.setString(3, customer.getCar());
	ps.setString(4, customer.getDate());
	
	//excecutes and closes connection and returns status
	int status=ps.executeUpdate();
	connection.close();
	return status;
		}
	}
	
	//delete customer method throwing sql exception
	public void deleteCustomer(int id) throws SQLException{

		//SQL statement to delete the row where name is whatever user has specified in the html page
		PreparedStatement ps=connection.prepareStatement("delete from cardatabase where name=?");
		ps.setInt(1, id);
		
		//executes it and prints it and closes connection
		int status=ps.executeUpdate();
		System.out.println(status);
		connection.close();
	}


}