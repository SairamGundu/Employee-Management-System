package com.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	private static List<Connection> connections = new ArrayList<Connection>();
	private static final String URL = "jdbc:postgresql://localhost:5432/employee";
	private static final String USN = "postgres";
	private static final String PWD = "root";
	private static int POOL_SIZE = 5;
	
	static {
		for (int i= 0; i< POOL_SIZE; i++) {
			connections.add(createConnection());
			
		}
	}
	
	private static Connection createConnection() 
	{
		try {
			return DriverManager.getConnection(URL,USN,PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
	
	public static Connection getConnection(){
		if(! connections.isEmpty()) {
			return connections.remove(0);
			
		}
		else {
			return createConnection();
		}
	}
	public static void receiveConnection(Connection connection) {
		if(connections.size() < POOL_SIZE) {
			connections.add(connection);
		}else {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	

}
