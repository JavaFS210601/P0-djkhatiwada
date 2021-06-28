package com.revature;

import java.util.Scanner;

public class InputValidation {

	int number1;
	int number2;
	int number3;
	int number; //Define double variable
	boolean Validation; //Define boolean
	Scanner scan = new Scanner(System.in); //Create a Keyboard object
	public int ValidateInput()
	{
		do
		{	System.out.println("------------------------------");
			System.out.println("       Welcome to DJ EMS");
			System.out.println("------------------------------");
			System.out.println("CHOOSE FROM FOLLOWING OPTIONS");
			System.out.println("------------------------------");
		
			//menu options
			System.out.println("Enter 1. ->  show all employees");			
			System.out.println("Enter 2. -> Get Employee and their Postion");
			System.out.println("Enter 3. -> Get Employee for Specific Positon");
			System.out.println("Enter 4. -> Get Employee Working in Specific Department");
			System.out.println("Enter 5. -> exit the application");
			System.out.println("Enter 6. -> add a new employee");
			System.out.println("Enter 7. -> delete employee");
			System.out.println("Enter 8. -> Get List of Positions");
			
			if(scan.hasNextInt())   //Check if the input is a double or not
			{
				number = scan.nextInt(); 
				
				//If it is Integer assign the value to number variable
				if(number <= 8) {
					number1 = number;
					Validation = true;
					  //Set boolean validation to true 
				}
				else {
					System.out.println("Please Enter a number between 1 and 8");
				}
								
						
			}
			else					//If the input is not a Integer
			{
				System.out.println("Invalid Entry(Input must be number between 1 and 8) !"); //Print error message
				Validation = false;						//set validation to false
				scan.next();						//get next input from user(this is needed to avoid infinite loop)
			}
			
		}while((!Validation));
		
		return number1;
	}
	
	
}
