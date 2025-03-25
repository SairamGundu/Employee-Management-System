package com.jsp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsp.dto.Employee;

public class EmployeeService {

	public static void saveEmployee(Employee employee) {
	Connection connection=ConnectionPool.getConnection();
	try {
		PreparedStatement preparedStatement= connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setInt(3, employee.getAge());
		preparedStatement.setLong(4, employee.getPhone());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setDouble(6, employee.getSalary());
		preparedStatement.setString(7, employee.getDepartment());
		preparedStatement.setDouble(8, employee.getExperience());
		int res= preparedStatement.executeUpdate();
		if(res==1) {
			System.out.println("Employee Details has been successfully stored");
		}
		else {
			System.out.println("Something went wrong");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally { 
		ConnectionPool.receiveConnection(connection);
	}
	}
	public static void fetchEmployeeById(int id) {
	Connection connection =ConnectionPool.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee where id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				System.out.println("***************Employee Details Are******************");
				System.out.println("Employee Id Is  : " + resultSet.getInt(1));
				System.out.println("Employee Name Is  : " + resultSet.getString(2));
				System.out.println("Employee Age Is  : " + resultSet.getInt(3));
				System.out.println("Employee Phone Is  : " + resultSet.getLong(4));
				System.out.println("Employee Email Is  : " + resultSet.getString(5));
				System.out.println("Employee Salary Is  : " + resultSet.getDouble(6));
				System.out.println("Employee Department Is  : " + resultSet.getString(7));
				System.out.println("Employee Experience Is  : " + resultSet.getDouble(8));
				
			}
			else {
				System.out.println("Employee With ID: " + id + " Does not Exits");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateEmployee(int id, int age) {
		Connection connection = ConnectionPool.getConnection();	
		try {
			CallableStatement callableStatement = connection.prepareCall("update employee set age =? where id =?");
			callableStatement.setInt(1, age);
			callableStatement.setInt(2, id);
			int res = callableStatement.executeUpdate();
			if(res==1)
			{
				System.out.println("Employee Details has been Successfully Updated");
			}
			else{
				System.out.println("Employee with the id:" + id+ ":Does Not Exist");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			ConnectionPool.receiveConnection(connection);
		}
	}
	
	public static void deleteEmployee(int id) {
		
		Connection connection = ConnectionPool.getConnection();	
		try {
			CallableStatement callableStatement = connection.prepareCall("delete from employee where id = ?");
			callableStatement.setInt(1, id);
			int res = callableStatement.executeUpdate();
			 if(res==1) {
				 
				 System.out.println("Employee Details has been Successfully Deleted");
				}
				else{
					System.out.println("Employee with the id:" + id+ ":Does Not Exist");
				}
				 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			ConnectionPool.receiveConnection(connection);
		}
		
		
	}
	
	
}
 