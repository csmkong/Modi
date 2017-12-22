package com.csmkong.ModiNailService.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.csmkong.ModiNailService.DTO.ItemDTO;

public class ItemDAO {
	public static final int QUERY_SUCCEED = 1;
	public static final int QUERY_FAILED = 0;
	private DataSource dataSource;

	public ItemDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/mssql");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public ArrayList<ItemDTO> selectItem(){
		ArrayList<ItemDTO> dtos = new ArrayList<ItemDTO>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "SELECT * FROM item";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String brand = resultSet.getString("brand");
				String item_type = resultSet.getString("item_type");
				int item_code = resultSet.getInt("item_code");
				String item_name = resultSet.getString("item_name");
				String fileName = resultSet.getString("fileName");
				
				dtos.add(new ItemDTO(brand,item_type,item_code,item_name,fileName));
				
			}
		}catch(Exception ex) {
			
		}finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
				if (resultSet != null ) resultSet.close();
			}catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public int insertItem(ItemDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = ItemDAO.QUERY_FAILED;
		try {
			connection = dataSource.getConnection();
			String query = "INSERT INTO item VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setNString(1, dto.getBrand());
			preparedStatement.setNString(2, dto.getItem_type());
			preparedStatement.setInt(3, dto.getItem_code());
			preparedStatement.setNString(4, dto.getItem_name());
			preparedStatement.setNString(5, dto.getFileName());
			rs = preparedStatement.executeUpdate();
			
			if(rs != ItemDAO.QUERY_SUCCEED) {
				System.out.println("insertion failed.");
			}
			
		}catch(Exception ex) {
			
		}finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
			}catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rs;
	}
	
	public int updateItem(ItemDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = ItemDAO.QUERY_FAILED;
		try {
			connection = dataSource.getConnection();
			String query = "UPDATE item SET item_type =?, item_name = ?, fileName = ? WHERE brand = ? AND item_code = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setNString(1, dto.getItem_type());
			preparedStatement.setNString(2, dto.getItem_name());
			preparedStatement.setNString(3, dto.getFileName());
			preparedStatement.setNString(4, dto.getBrand());
			preparedStatement.setInt(5, dto.getItem_code());
			rs = preparedStatement.executeUpdate();
			
			if(rs != ItemDAO.QUERY_SUCCEED) {
				System.out.println("Update failed.");
			}
			
		}catch(Exception ex) {
			
		}finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
			}catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rs;
	}

	public int deleteItem(ItemDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rs = ItemDAO.QUERY_FAILED;
		try {
			connection = dataSource.getConnection();
			String query = "DELETE FROM item WHERE brand = ? AND item_type = ? AND item_code = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setNString(1, dto.getBrand());
			preparedStatement.setNString(2, dto.getItem_type());
			preparedStatement.setInt(3, dto.getItem_code());
			rs = preparedStatement.executeUpdate();
			
			if(rs != ItemDAO.QUERY_SUCCEED) {
				System.out.println("Deletion failed.");
			}
			
		}catch(Exception ex) {
			
		}finally {
			try {
				if (connection != null) connection.close();
				if (preparedStatement != null) preparedStatement.close();
			}catch(Exception ex2) {
				ex2.printStackTrace();
			}
		}
		return rs;
	}
}

