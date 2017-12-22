package com.csmkong.ModiNailService.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class InventoryDAO {
	private DataSource dataSource;

	public InventoryDAO() {
		try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mssql");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		if(dataSource == null){
			System.out.println("!!!!!!!!!!!!!dataSource is null.");
		}
	}
	
	public void getItem(){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			System.out.println("before get Connection");
			
			connection = dataSource.getConnection();
			
			System.out.println("After get connection");
			
			statement = connection.createStatement();
			String query = "SELECT * FROM userinfo";
			resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				System.out.println(id);
				
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				if(connection != null ) connection.close();
				if(statement != null ) statement.close();
				if(resultSet != null ) resultSet.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
