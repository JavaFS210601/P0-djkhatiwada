package com.revature.models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import com.revature.daos.PositionInterface;
import com.revature.util.ConnectionUtil;

public class Position  {

	private int position_id;
	private String position_name;
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Position(String position_name) {
		super();
		this.position_name = position_name;
	}
	public Position(int position_id, String position_name) {
		super();
		this.position_id = position_id;
		this.position_name = position_name;
	}
	@Override
	public String toString() {
		return "Position [position_id=" + position_id + ", position_name=" + position_name + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position_id;
		result = prime * result + ((position_name == null) ? 0 : position_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (position_id != other.position_id)
			return false;
		if (position_name == null) {
			if (other.position_name != null)
				return false;
		} else if (!position_name.equals(other.position_name))
			return false;
		return true;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public String getPosition_name() {
		return position_name;
	}
	public void setPosition_name(String position_name) {
		this.position_name = position_name;
	}
	
	 
	
}
