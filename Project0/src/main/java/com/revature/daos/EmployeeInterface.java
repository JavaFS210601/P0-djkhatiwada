package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;



public interface EmployeeInterface {

public List<Employee> getEmployee();
	
public void getEmployeePosition();
public void getEmployeebyPosition(int PositionID);
public void getEmployeebyDepartment(int DepartmentID);	
public void addEmployees(Employee emp);
public void deleteEmployee(String fname, String lname);
	//public void ChangeManaager(int id, int role);
	
	//public void removeEmployee(int empID);
}
