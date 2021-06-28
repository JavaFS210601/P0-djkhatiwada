package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.revature.daos.PositionDaso;
import com.revature.models.Employee;
import com.revature.models.Menu;
import com.revature.models.Position;
import com.revature.util.ConnectionUtil;



public class Launcher {

	public static void main(String[] args) {
		//here we are just testing weather our connectin from connectionUtil class is successful.
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection successful");
		} catch(SQLException e) {
			e.printStackTrace();
		}

		
		
		
		//instansiate a menu object so we can use display method
		Menu menu = new Menu();
		
		//run the display method, delivering the user's optons
		menu.display();
	}

}
