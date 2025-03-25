package com.jsp.dto;

public class Employee {

	private int id;
	private  String name;
	private int age;
	private long phone;
	private String email;
	private double salary;
	private String department;
	private double experience;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getExperience() {
		return experience;
	}
	public void setExperience(double experience) {
		this.experience = experience;
	}
	public Employee(int id, String name, int age, long phone, String email, double salary, String department,
			double experience) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.salary = salary;
		this.department = department;
		this.experience = experience;
	}
	
	
	
	
}
