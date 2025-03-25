package com.jsp.Driver;

import java.util.Scanner;

import com.jsp.dao.EmployeeService;
import com.jsp.dto.Employee;

public class Driver1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1) Enter 1 to Add a new Employee: ");
		System.out.println("2) Enter 2 to Fetch a Existing Employee Details by ID: ");
		System.out.println("3) Enter 3 to Update a Existing Employee Details by ID: ");
		System.out.println("4) Enter 4 to Delete a Existing Employee Details by ID: ");
		
		int choice = sc.nextInt();
		System.out.println("****************************************************");
		
		if( choice ==1) {
			System.out.println("Enter the Employee id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the Employee Name: ");
			String name = sc.nextLine();
			System.out.println("Enter the Employee age: ");
			int age = sc.nextInt();
			System.out.println("Enter the Employee Phone: ");
			long phone = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the Employee Email: ");
			String email = sc.nextLine();
			System.out.println("Enter the Employee Salary: ");
			double salary =  sc.nextDouble();
			sc.nextLine();
			System.out.println("Enter the Employee Department");
			String department= sc.nextLine();
			System.out.println("Enter the Employee Experience");
			double experience = sc.nextDouble ();
			
		
			Employee employee = new Employee(id,name,age, phone,email, salary, department, experience);
			EmployeeService.saveEmployee(employee);	

		}
		else if (choice == 2) {
			System.out.println("Enter the Employee id whose details Needs to be Fetched: ");
			int id =sc.nextInt();
			EmployeeService.fetchEmployeeById(id);
		}
		
		else if (choice == 3) {
		 
			System.out.println("Enter the employee id whose details needs to be updated: ");
			int id= sc.nextInt();
			System.out.println("Enter The  Employee new age: ");
			int age= sc.nextInt();
			EmployeeService.updateEmployee(id,age);
			
		}
		
		else if (choice == 4) {
			 
			System.out.println("Enter the employee id whose details needs to be deleted: ");
			int id= sc.nextInt();
			EmployeeService.deleteEmployee(id);
			
		}
		


		}
	
	}

