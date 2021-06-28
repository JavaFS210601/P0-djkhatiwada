package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Position;
import com.revature.util.ConnectionUtil;

public class PositionDaso implements PositionInterface {

	@Override
	public List<Position> getEmployee() {
		try(Connection C = ConnectionUtil.getConnection()){
			
			ResultSet rst = null;
			String sql = "SELECT * FROM \"P0\".Positions;";
			Statement s = C.createStatement();
			rst = s.executeQuery(sql);
			
			List<Position> PositionList = new ArrayList<>();
			while(rst.next()) { //while there are results left in rs
				//create a new employee object from each returned record
				
				Position e = new Position(
					rst.getInt("position_id"), 
					rst.getString("position_name")
									
						);
					
				//add newly created Employee object into the ArrayList of Employees
				
				PositionList.add(e);
				
				
			}
			
			return PositionList;
			
			
		}
		catch(SQLException e) {
			System.out.println("Something went wrong while trying to connecto to database");
			e.printStackTrace();
		}
		return null;
	}

}
