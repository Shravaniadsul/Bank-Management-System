package com.solution.controller;
import java.util.Scanner;

import com.solution.service.ServiceImpl;
import com.solution.Employee.Employee;
import com.solution.service.IService;


      
public class ControllerImpl implements IController {
	 Scanner sc = null;
     Employee emp = null;
     IService service = null;
     

	@Override
	public Employee select(Integer Serial_no) {
		
		
		 service = new ServiceImpl();
		 emp =service.select(Serial_no);
		
	    return emp;
		
		
	}

	@Override
	public void insert(Employee emp) {
service = new ServiceImpl();
		
		int rowCount = service.insert(emp);
		if(rowCount != 0) {
			System.out.println("Data Inserted Sucessfully");
		}else {
			System.out.println("Data Insertion Failed");
		}
	
	}
	

	@Override
	public void update(Employee emp) {
//		sc= new Scanner(System.in);
//		System.out.print("Enter Serial_no whose data to be updated:: ");
//		Integer Serial_no = sc.nextInt();
//		
//		System.out.print("Name :: ");
//		String name = sc.next();
//		
//		System.out.print("Account_no :: ");
//		Long Account_no = sc.nextLong();
//		
//		System.out.print("IFSC_no :: ");
//		String IFSC_no = sc.next();
//		
//		System.out.print("Balance :: ");
//		Integer Balance = sc.nextInt();
//		
//		emp = new Employee();
//		emp.setSerial_no(Serial_no);
//		emp.setName(name);
//		emp.setAccount_no(Account_no);
//		emp.setIFSC_no(IFSC_no);
//		emp.setBalance(Balance);
//		
		service = new ServiceImpl();
		
		Integer rowCount = service.update(emp);
		if(rowCount != 0) {
			System.out.println("Data Updated Sucessfully");
		}else {
			System.out.println("Data Updation Failed");
		}
		
		
	}

	@Override
	public Integer delete(Integer Serial_no) {
		Integer rowCount = null;

		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter Serial_no to delete record: ");
//		int Serial_no = sc.nextInt();
		service = new ServiceImpl();
		
		 rowCount = service.delete(Serial_no);
			return rowCount;
			

		
	}

	

}
