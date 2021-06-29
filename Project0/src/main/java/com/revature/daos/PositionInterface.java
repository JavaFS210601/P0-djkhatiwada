package com.revature.daos;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Position;

public interface PositionInterface {

	public List<Position> getPosition();
	public void addPostion(Position pos);
}
