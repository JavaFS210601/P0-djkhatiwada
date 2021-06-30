package com.revature.models;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.validation.InputValidation;
import com.revature.daos.DepartmentDaos;
import com.revature.daos.Empoyeedaos;
import com.revature.daos.PositionDaso;

public class Menu{

	Empoyeedaos ed = new Empoyeedaos();
	PositionDaso P = new PositionDaso();
	DepartmentDaos D = new DepartmentDaos();
	InputValidation V = new InputValidation();
	boolean validation;
	Scanner scanner = new Scanner(System.in);
	//All of the manu display options and control flow are conatined in this method
	public  void display() {
		
		boolean displayMenu = true; //this toggles weather the menu continues after user input
		final Logger log = LogManager.getLogger(Menu.class);
		
		while(displayMenu) {
			int input = V.ValidateInput();
		
			//switch statements that takes the user input and does some logic depending on that input 
				switch(input) {
				case 1:{
					
					System.out.println("Gathering all employees....");
					
					List<Employee> employees = ed.getEmployee();
					for(Employee e: employees) {
						System.out.println(e.getEmployee_ID()+"). " + e.getEmployee_fname() +" " + e.getEmployee_lname() + "Salary = " + e.getEmployee_salary()
						+ ", Address: " + e.getEmployee_address() + "," + e.getEmployee_city() + "," + e.getEmployee_state()
						+ "," + e.getEmployee_Zip() + ", Position ID: " + e.getPosition_id() +", Department ID: " +e.getDepartment_id());
					}
					break;
				}
				case 2:{
					log.info("User Selected all Employees and their position");
					ed.getEmployeePosition();
					
					break;
				}
				case 3: {
					System.out.println("Enter the Positon ID to get all employee with that positon");
					System.out.println("1.'Assistant Manager', 2.'Cashier', 3.'Department Head'");
					int input1 = scanner.nextInt();
					if(input1 == 1) {
						System.out.println("List Of Assistant Managers");
					}
					else if(input1 == 2) {
						System.out.println("List of Cashiers");
					}
					else if (input1 ==3) {
						System.out.println("List of Department head");
					}
					ed.getEmployeebyPosition(input1);
					
					break;
				}
				
				case 4: {
					System.out.println("Enter the Department to get all employee in that Department");
					System.out.println("1.'Electronics', 2.'Toys', 3.'Apparel' , 4.'Lawn and Garden' 5.'Hardware' 6.'Food'");
					int input2 = scanner.nextInt();
					if(input2 == 1) {
						System.out.println("List of employee Working in Electronics Department");
					}
					else if(input2 == 2) {
						System.out.println("List of employee Working in Toys Department");
					}
					else if(input2 ==3) {
						System.out.println("List of employee Working in Apparel Department");
					}
					else if(input2 == 4) {
						System.out.println("List of employee Working in Lawn and Garden Department");
					}
					else if(input2 ==5) {
						System.out.println("List of employee Working in Hardware Department");
					}
					else if(input2 ==6) {
						System.out.println("List of employee Working in Food Department");
					}
					ed.getEmployeebyDepartment(input2);
					
					break;
				}
				
				case 5: {
					System.out.println("Enter Employee First Name:");
					String employee_fname = scanner.nextLine();
					
					System.out.println("Enter Employees Last Name");
					String employee_lname = scanner.nextLine();
					
					System.out.println("Enter Employees Salary");
					double employee_salary = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.println("Enter Employees Address");
					String employee_address = scanner.nextLine();
					
					System.out.println("Enter Employees City");
					String employee_city = scanner.nextLine();
					
					System.out.println("Enter Employees State");
					String employee_state = scanner.nextLine();
					
					System.out.println("Enter Employees Zip Code");
					String employee_zip = scanner.nextLine();
					System.out.println("Enter Position Id: 1)Manager 2)Cashier 3)Department head");		
					int position_id_fk = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Enter Department Id:");		
					System.out.println("1)'Electronics', 2)'Toys', 3)'Apparel', 4)'Lawn and Garden' 5)'Hardware' 6)'Food'");
					int department_id_fk = scanner.nextInt();
					scanner.nextLine();
										
					//given all this information we will create new employee object to send to DAO method
					Employee newEmployee1 = new Employee(employee_fname, employee_lname, employee_salary, employee_address, 
							employee_city,employee_state, employee_zip, position_id_fk, department_id_fk);
					//put the new employee into the addEmployee() method in the employeedao
					
					ed.addEmployees(newEmployee1);
					break;				
				}
				case 6: {
					log.warn("User deleted an employee");
					System.out.println("Please Enter First Name of Employee you want to Delete");
					String fname = scanner.nextLine();
					System.out.println("Please Enter Last Name of Employee you want to Delete");
					String Lname = scanner.nextLine();
					
					ed.deleteEmployee(fname, Lname);
					break;
				}
				case 7: {
					System.out.println("List of all Position");
					System.out.println("---------------------");
					List<Position> positions = P.getPosition();
					
					for(Position p: positions) {
						System.out.println(p.getPosition_id() +")." + p.getPosition_name());
					}
					break;
					
				}
				case 8: {
					System.out.println("List of all Departments");
					System.out.println("-----------------------");
					List<Department> departments = D.getDepartments();
					
					for(Department D: departments) {
						System.out.println(D.getDepartment_id() + "). " + D.getDepartment_name());
					}
					break;		
				}
				case 9: {
					System.out.println("Please Enter new Positon you want to add");
					String position_name = scanner.nextLine();
					Position newPosition = new Position(position_name);
					
					P.addPostion(newPosition);
					break;
					
				}
				case 10: {
					log.info("User Exited the application");
					System.out.println("----------------------------------");
					System.out.println("Thank You for using our service :)");
					displayMenu = false;
					break;
					
				}
				default: {
					
					System.out.println("Invlid entry, please try again");
					
				}
				
				}
			
		}
		
	}
}
