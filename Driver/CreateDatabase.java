package com.jsp.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {
public static void main(String[] args) {
	try {
		Connection connection =DriverManager.getConnection("jdbc:postgresql://localhost:5432/","postgres","root");
		Statement statement=connection.createStatement();
		int res = statement.executeUpdate("create database employee");
		System.out.println(res);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
