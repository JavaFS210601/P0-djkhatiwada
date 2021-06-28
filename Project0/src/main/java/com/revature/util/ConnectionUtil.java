package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//This class contains the logic that manages the connection to our database
//It will have a method called getconnection() that will return connection objects
//we will need these connection objects in our DAO layer to interact with our database
public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException{
		
		//for compaibility with other technologies/frameworks, we will need to register our Driver 
		//this process makes application of what driver class(what SQL dialet) we are using
		
		try {
			Class.forName("org.postgresql.Driver"); //try to find and return the postgresql driver class
		}catch(ClassNotFoundException e) {
			System.out.println("Class wasn't found :(");
			e.printStackTrace();  //prints the exceptoin message to the console
		}
		
		//we need to provide our database credentials
		//we will hardcode thme for now, but we will see how to hide this username/password in environment variables
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema = P0";
		String username = "postgres";
		String password = "Bishnu62#"; //this will be whatever password you set in postgres
		
		
		return DriverManager.getConnection(url, username, password);
	}
	

}
