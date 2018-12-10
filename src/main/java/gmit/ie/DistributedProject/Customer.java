package gmit.ie.DistributedProject;

import com.fasterxml.jackson.annotation.JsonProperty;

//Customer class 
public class Customer{
	
	//using the json property annotaion to assign each variable from the database (MYSQL)
	@JsonProperty
	int id;
	@JsonProperty
	String name;
	@JsonProperty
	int phoneNumber;
	@JsonProperty
	String city;
	@JsonProperty
	String country;
	@JsonProperty
	String car;
	@JsonProperty
	String date;
	
	
public Customer() {
super();
}
//Setting each variable
public Customer(int id, String name,int phoneNumber,String city,String country,String car,String date) {
super();
this.id = id;
this.name = name;
this.phoneNumber=phoneNumber;
this.city =city;
this.country = country;
this.car = car;
this.date = date;
}

//getters and setters methods

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(int phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getCar() {
	return car;
}

public void setCar(String car) {
	this.car = car;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

}