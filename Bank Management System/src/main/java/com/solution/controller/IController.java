package com.solution.controller;

import com.solution.Employee.Employee;

public interface IController {
	public Employee select(Integer Serial_no);
	public void insert(Employee emp);
	public void update(Employee emp);
	public Integer delete(Integer Serial_no);
	


}
