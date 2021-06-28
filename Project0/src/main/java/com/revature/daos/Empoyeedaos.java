package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.*;





public class Empoyeedaos implements EmployeeInterface {

	@Override
	public List<Employee> getEmployee() {
		try(Connection C = ConnectionUtil.getConnection()){
			
			ResultSet rset = null; //initialize an empty resultset that will store the results of our query
			
			String sql = "SELECT * from  \"P0\".employees;"; //write a query, assign it to a string variable
			
			Statement s = C.createStatement(); //creating an object to send the query to our DB
			
			rset = s.executeQuery(sql); //execute the query(sql) using our statements objects(s), put it in our ResultSet(rs)
			
			List<Employee> employeeList = new ArrayList<>(); //create a list that will be populated with the retruned employees
			
			while(rset.next()) { //while there are results left in rs
				//create a new employee object from each returned record
				
				Employee e = new Employee(
					rset.getInt("employee_Id"), 
					rset.getString("employee_fname"),
					rset.getString("employee_lname"),
					rset.getDouble("employee_salary"),
					rset.getString("employee_address"),
					rset.getString("employee_city"),
					rset.getString("employee_state"),
					rset.getString("employee_zip"),
					rset.getInt("position_id_fk"),
					rset.getInt("department_id_fk")
						
						);					
				//add newly created Employee object into the ArrayList of Employees
				
				employeeList.add(e);						
			}			
			return employeeList; //Finally if successful get the list of employee
			
		}catch(SQLException e) {
			System.out.println("Something went wrong while trying to access your DB");
			e.printStackTrace();
		}				
		return null;		
	}

	@Override
	public void getEmployeePosition() {
		try(Connection C = ConnectionUtil.getConnection()){
			
			ResultSet rset = null; //initialize an empty resultset that will store the results of our query
			
			String sql = "SELECT employee_fname, employee_lname, position_name FROM \"P0\".employees "
					+ "JOIN \"P0\".Positions "
					+ "ON position_id_fk = position_id"; //write a query, assign it to a string variable
			
			Statement s = C.createStatement(); //creating an object to send the query to our DB
			
			rset = s.executeQuery(sql); //execute the query(sql) using our statements objects(s), put it in our ResultSet(rs)			
			System.out.println();
			while(rset.next()) { //while there are results left in rs
				//create a new employee object from each returned record
				
				String FirstName = rset.getString("employee_fname");  // retrieve a 'String'-cell in the row
	            String LastName = rset.getString("employee_lname");  // retrieve a 'double'-cell in the row
	            String Position   = rset.getString("position_name");       // retrieve a 'int'-cell in the row
					
				//add newly created Employee object into the ArrayList of Employees
	            
	            System.out.println("----------------------------------");
	            System.out.println(FirstName + "  " + LastName + "--> " + Position);						
			}			
		}catch(SQLException e) {
			System.out.println("Something went wrong while trying to access your DB");
			e.printStackTrace();
		}						
	}

	@Override
	public void getEmployeebyPosition(int PositionID) {
try(Connection C = ConnectionUtil.getConnection()){
				
			ResultSet rset = null;
			String sql = "SELECT employee_fname, employee_lname FROM \"P0\".employees  WHERE position_id_fk = ?;";
			
			PreparedStatement ps = C.prepareStatement(sql); // we used preapred statements for sql commands with parameters
			
			ps.setInt(1, PositionID);
			rset = ps.executeQuery(); //we use executeUpdate fro insertin, updates and deletes
			
			while(rset.next()) { //while there are results left in rs
				
				
				String FirstName = rset.getString("employee_fname");  // retrieve a 'String'-cell in the row
	            String LastName = rset.getString("employee_lname");  // retrieve a 'double'-cell in the row
	                	            
	            System.out.println("--------------------------");
	            System.out.println(FirstName + "  " + LastName );						
			}
		}
		catch(SQLException e) {
			System.out.println("Operation failed to get employee by Positon");
			e.printStackTrace();
		}		
	}

	@Override
	public void getEmployeebyDepartment(int DepartmentID) {
		try(Connection C = ConnectionUtil.getConnection()){
			
			ResultSet rset = null;
			String sql = "SELECT employee_fname, employee_lname FROM \"P0\".employees  WHERE department_id_fk = ?;";
			
			PreparedStatement ps = C.prepareStatement(sql); // we used preapred statements for sql commands with parameters
			
			ps.setInt(1, DepartmentID);
			rset = ps.executeQuery(); //we use executeUpdate fro insertin, updates and deletes
			
			while(rset.next()) { //while there are results left in rs
				//create a new employee object from each returned record
				
				String FirstName = rset.getString("employee_fname");  // retrieve a 'String'-cell in the row
	            String LastName = rset.getString("employee_lname");  // retrieve a 'double'-cell in the row
	                  // retrieve a 'int'-cell in the row
					
				//add newly created Employee object into the ArrayList of Employees
	            
	            System.out.println("--------------------------");
	            System.out.println(FirstName + "  " + LastName );						
			}
		}
		catch(SQLException e) {
			System.out.println("Operatin Failed ot get employee by department");
			e.printStackTrace();
		}
		
	}

	@Override
	public void addEmployees(Employee emp1) {
		try(Connection C = ConnectionUtil.getConnection()){						
			//we are going to create a sql statement using parameters to insert a new employee
			
			String sql = "INSERT INTO \"P0\".employees(employee_fname, employee_lname, employee_salary, employee_address,employee_city, employee_state, employee_zip, position_id_fk, department_id_fk )"
					+ "VALUES(?, ?, ?, ?, ? , ?, ?, ?, ?);";
			
			PreparedStatement ps = C.prepareStatement(sql); //use preapred statements for sql command with parameters
			
			//used the preapredstatement object to insert values into the SQL query
			//the values will come from the Employee object we sent in
			
			ps.setString(1, emp1.getEmployee_fname());
			ps.setString(2, emp1.getEmployee_lname());
			ps.setDouble(3, emp1.getEmployee_salary());
			ps.setString(4, emp1.getEmployee_address());
			ps.setString(5, emp1.getEmployee_city());
			ps.setString(6, emp1.getEmployee_state());
			ps.setString(7, emp1.getEmployee_Zip());
			ps.setInt(8, emp1.getPosition_id());
			ps.setInt(9, emp1.getDepartment_id());
			
			//this method executes the sql command that we built
			ps.executeUpdate(); //we use executeUpdate for Insert(Also for update and delete)
			
			//send conformation to the console if successful
			System.out.println("New Employee " + emp1.getEmployee_fname() + emp1.getEmployee_lname() + " added to database");					
		}
		catch(SQLException e) {
			System.out.println("Something wrong! Add employee failed!");
		}		
	}

	@Override
	public void deleteEmployee(String fname, String lname) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "Delete from  \"P0\".employees WHERE employee_fname = ? and  employee_lname = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql); // we used preapred statements for sql commands with parameters
			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.executeUpdate(); //we use executeUpdate fro insertin, updates and deletes
			
			System.out.println(fname +" "+ lname + " Deleted from system");
		}
		catch(SQLException e) {
			System.out.println("Delete employee failed");
			e.printStackTrace();
		}
		
	}

	
}
