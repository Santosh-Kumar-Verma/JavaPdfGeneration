package com.test.dto;

public class Employee {

	private Long employeeId;
	private Long mobileNo;
	private String empName;

	public Employee() {}
	
	public Employee(Long employeeId, Long mobileNo, String empName) {
		super();
		this.employeeId = employeeId;
		this.mobileNo = mobileNo;
		this.empName = empName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
}
