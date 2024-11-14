package com.solution.Employee;

public class Employee {
	private Integer Serial_no;
	private String name;
	private Long Account_no;
	private String IFSC_no;
	private Integer Balance; 
	
   
	public Employee(){
		
	}


	public Integer getSerial_no() {
		return Serial_no;
	}


	public void setSerial_no(Integer serial_no) {
		Serial_no = serial_no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getAccount_no() {
		return Account_no;
	}


	public void setAccount_no(Long account_no) {
		Account_no = account_no;
	}


	public String getIFSC_no() {
		return IFSC_no;
	}


	public void setIFSC_no(String iFSC_no) {
		IFSC_no = iFSC_no;
	}


	public Integer getBalance() {
		return Balance;
	}


	public void setBalance(Integer balance) {
		Balance = balance;
	}


	@Override
	public String toString() {
		return "Employee [Serial_no=" + Serial_no + ", name=" + name + ", Account_no=" + Account_no + ", IFSC_no="
				+ IFSC_no + ", Balance=" + Balance + "]";
	}
	
	
}
