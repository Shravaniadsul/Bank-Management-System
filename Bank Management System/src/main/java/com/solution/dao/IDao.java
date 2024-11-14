package com.solution.dao;

import com.solution.Employee.Employee;

public interface IDao {
	public Employee select(int Serial_no );
	public Integer insert(Employee emp);
	
	public Integer delete(int Serial_no);
	public Integer update(Employee emp);

		

}
