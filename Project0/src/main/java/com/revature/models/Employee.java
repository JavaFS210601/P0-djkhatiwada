package com.revature.models;

public class Employee {

	private int employee_ID;
	private String employee_fname;
	private String employee_lname;
	private double employee_salary;
	private String employee_address;
	private String employee_city;
	private String employee_state;
	private String employee_Zip;
	private int position_id;
	private int department_id;
	
	
	//no arg constructor
	public Employee() {
		super();
		

	}
		
	//constructor without employee id
	public Employee(String employee_fname, String employee_lname, double employee_salary, String employee_address,
			String employee_city, String employee_state, String employee_Zip, int position_id, int department_id) {
		super();
		this.employee_fname = employee_fname;
		this.employee_lname = employee_lname;
		this.employee_salary = employee_salary;
		this.employee_address = employee_address;
		this.employee_city = employee_city;
		this.employee_state = employee_state;
		this.employee_Zip = employee_Zip;
		this.position_id = position_id;
		this.department_id = department_id;
	}

	//all args constuctor
	public Employee(int employee_ID, String employee_fname, String employee_lname, double employee_salary,
				String employee_address, String employee_city, String employee_state, String employee_Zip,
				int position_id, int department_id) {
		super();
		this.employee_ID = employee_ID;
		this.employee_fname = employee_fname;
		this.employee_lname = employee_lname;
		this.employee_salary = employee_salary;
		this.employee_address = employee_address;
		this.employee_city = employee_city;
		this.employee_state = employee_state;
		this.employee_Zip = employee_Zip;
		this.position_id = position_id;
		this.department_id = department_id;
		}
	
	//To string method
		@Override
		public String toString() {
			return "Employee [employee_ID=" + employee_ID + ", employee_fname=" + employee_fname + ", employee_lname="
					+ employee_lname + ", employee_salary=" + employee_salary + ", employee_address=" + employee_address
					+ ", employee_city=" + employee_city + ", employee_state=" + employee_state + ", employee_Zip="
					+ employee_Zip + ", position_id=" + position_id + ", department_id=" + department_id + "]";
		}
		
		//Hashcode method
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + department_id;
			result = prime * result + employee_ID;
			result = prime * result + ((employee_Zip == null) ? 0 : employee_Zip.hashCode());
			result = prime * result + ((employee_address == null) ? 0 : employee_address.hashCode());
			result = prime * result + ((employee_city == null) ? 0 : employee_city.hashCode());
			result = prime * result + ((employee_fname == null) ? 0 : employee_fname.hashCode());
			result = prime * result + ((employee_lname == null) ? 0 : employee_lname.hashCode());
			long temp;
			temp = Double.doubleToLongBits(employee_salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((employee_state == null) ? 0 : employee_state.hashCode());
			result = prime * result + position_id;
			return result;
		}
		
		//equals method
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (department_id != other.department_id)
				return false;
			if (employee_ID != other.employee_ID)
				return false;
			if (employee_Zip == null) {
				if (other.employee_Zip != null)
					return false;
			} else if (!employee_Zip.equals(other.employee_Zip))
				return false;
			if (employee_address == null) {
				if (other.employee_address != null)
					return false;
			} else if (!employee_address.equals(other.employee_address))
				return false;
			if (employee_city == null) {
				if (other.employee_city != null)
					return false;
			} else if (!employee_city.equals(other.employee_city))
				return false;
			if (employee_fname == null) {
				if (other.employee_fname != null)
					return false;
			} else if (!employee_fname.equals(other.employee_fname))
				return false;
			if (employee_lname == null) {
				if (other.employee_lname != null)
					return false;
			} else if (!employee_lname.equals(other.employee_lname))
				return false;
			if (Double.doubleToLongBits(employee_salary) != Double.doubleToLongBits(other.employee_salary))
				return false;
			if (employee_state == null) {
				if (other.employee_state != null)
					return false;
			} else if (!employee_state.equals(other.employee_state))
				return false;
			if (position_id != other.position_id)
				return false;
			return true;
		}
		
		
		//Getter and setter methods
		public int getEmployee_ID() {
			return employee_ID;
		}
		public void setEmployee_ID(int employee_ID) {
			this.employee_ID = employee_ID;
		}
		public String getEmployee_fname() {
			return employee_fname;
		}
		public void setEmployee_fname(String employee_fname) {
			this.employee_fname = employee_fname;
		}
		public String getEmployee_lname() {
			return employee_lname;
		}
		public void setEmployee_lname(String employee_lname) {
			this.employee_lname = employee_lname;
		}
		public double getEmployee_salary() {
			return employee_salary;
		}
		public void setEmployee_salary(double employee_salary) {
			this.employee_salary = employee_salary;
		}
		public String getEmployee_address() {
			return employee_address;
		}
		public void setEmployee_address(String employee_address) {
			this.employee_address = employee_address;
		}
		public String getEmployee_city() {
			return employee_city;
		}
		public void setEmployee_city(String employee_city) {
			this.employee_city = employee_city;
		}
		public String getEmployee_state() {
			return employee_state;
		}
		public void setEmployee_state(String employee_state) {
			this.employee_state = employee_state;
		}
		public String getEmployee_Zip() {
			return employee_Zip;
		}
		public void setEmployee_Zip(String employee_Zip) {
			this.employee_Zip = employee_Zip;
		}
		public int getPosition_id() {
			return position_id;
		}
		public void setPosition_id(int position_id) {
			this.position_id = position_id;
		}
		public int getDepartment_id() {
			return department_id;
		}
		public void setDepartment_id(int department_id) {
			this.department_id = department_id;
		}
	
		
	


	
	
	
	
	
}
