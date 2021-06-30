package com.validation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Employee;
import com.revature.util.*;

public class InputValidation {

	int number1;
	int number2;
	int number3;
	int number; //Define double variable
	boolean Validation; //Define boolean
	boolean Validation1;
	final Logger log = LogManager.getLogger(InputValidation.class);
	
	Scanner scan = new Scanner(System.in); //Create a Keyboard object
	public int ValidateInput()
	{
		do
		{	System.out.println("------------------------------");
			System.out.println("       Welcome to DJ EMS");
			System.out.println("------------------------------");
			System.out.println("CHOOSE FROM FOLLOWING OPTIONS:");
			System.out.println("------------------------------");
		
			//menu options
			System.out.println("Enter 1. -> Show all employees detail");			
			System.out.println("Enter 2. -> Get Employee and their Postion.");
			System.out.println("Enter 3. -> Get Employee for Specific Positon");
			System.out.println("Enter 4. -> Get Employee Working in Specific Department");			
			System.out.println("Enter 5. -> add a new employee");
			System.out.println("Enter 6. -> delete employee.");
			System.out.println("Enter 7. -> Get List of Positions");
			System.out.println("Enter 8. -> Get List of Departments");
			System.out.println("Enter 9. -> Add a position");
			System.out.println("Enter 10. -> exit the application.");
			
			if(scan.hasNextInt())   //Check if the input is a double or not
			{
				number = scan.nextInt(); 
				
				//If it is Integer assign the value to number variable
				if(number <= 10) {
					log.info("User input was correct");
					number1 = number;
					Validation = true;
					  //Set boolean validation to true 
				}
				else {
					log.info("User entered number grater than 10");
					System.out.println("Please Enter a number between 1 and 10");					
				}						
			}
			else					//If the input is not a Integer
			{
				log.info("User Input was not valid");
				System.out.println("Invalid Entry(Input must be number between 1 and 10) !"); //Print error message
				Validation = false;						//set validation to false
				scan.next();						//get next input from user(this is needed to avoid infinite loop)
				
			}
			
		}while((!Validation));
		
		return number1;
	}
	
		
}
	
	

