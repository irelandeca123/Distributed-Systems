package gmit.ie.Database;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import gmit.ie.DistributedProject.Customer;

//default path = /myresource
@Path("/myresource")
public class MyResource {
	DAO dao= new DAO();
	

	//get method display result in JSON format 	
	//list of customers (array) access the DAO class and get all customers then return the list of it 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public List<Customer> getCustomer(){
	List<Customer> listOfCountries= dao.getAllCustomers();
	
	return listOfCountries;
	}

	//another get method to search for specified name from the html form using formparam and then 
	//carry it over to DAO class getCustomer method and set each variable for display
	 @GET
	 @Path("customer")
	 @Produces(MediaType.APPLICATION_JSON)
public Customer getCountryById(@FormParam("nameSearch") String name){
		 return dao.getCustomer(name);
	 }	
	 
	//post method display in JSON , add customer using the formparam from the html form and assign each
	//variable accordingly and then throw sql exception
	 @POST	
	 @Produces(MediaType.APPLICATION_JSON)
	 public Customer addCustomer
	 		 (@FormParam("name") String name,
             @FormParam("phoneNumber") int phoneNumber,
             @FormParam("city")String city,
             @FormParam("country")String country,
             @FormParam("car")String car
             ) throws SQLException {
		 
		 Customer customer = new Customer();
		 customer.setName(name); 
		 customer.setPhoneNumber(phoneNumber);
		 customer.setCity(city);
		 customer.setCountry(country);
		 customer.setCar(car);		 
		 return dao.addCustomer(customer);
}
	 
	//delete call , in order to delete a row depending on the name for database changes (CRUD)
	 @DELETE
	 @Path("/{nameSearch}")
	 @Produces(MediaType.APPLICATION_JSON)
public void deleteCountry(@PathParam("id") int id) throws SQLException{
		 dao.deleteCustomer(id);
	 }	
	
	//Put call to update a table in mySQL so it displays it JSON and uses the DAO class
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
public int updateCountry(Customer customer) throws SQLException{
		 return dao.updateCustomer(customer);
	 }
	
    
}
