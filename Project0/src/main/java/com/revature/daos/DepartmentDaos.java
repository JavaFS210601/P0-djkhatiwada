package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Department;

import com.revature.util.ConnectionUtil;

public class DepartmentDaos implements DepartmentInterface {

	@Override
	public List<Department>  getDepartments() {
		try(Connection C = ConnectionUtil.getConnection()){
			ResultSet rst = null;
			String sql = "SELECT * FROM \"P0\".departments;";
			
			Statement s = C.createStatement();
			
			rst = s.executeQuery(sql);
			
			List<Department> DepartmentList = new ArrayList<>();
			
			while(rst.next()) { //while there are results left in rs
				//create a new employee object from each returned record
				
				Department d = new Department(
					rst.getInt("department_id"), 
					rst.getString("department_name")
									
						);					
				//add newly created Department object into the ArrayList of Department
				
				DepartmentList.add(d);								
			}
				return DepartmentList;			
		}
		catch(SQLException e) {
			System.out.println("Problem connecting with database");
			e.printStackTrace();
		}
		return null;		
	}
}
