package jd.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jd.model.Item;
import jd.utils.OracleQueries;

public class ItemDAO {
	
	public Item	getItemById(Integer item_id) throws SQLException {
		Item item = null;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn= OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETITEMBYID);
			stmt.setInt(1, item_id);
			// execute query is only for reading data from the database 
			result = stmt.executeQuery();
			
				while(result!= null && result.next()) {
					item = new Item();
					
					item.setItem_id(result.getInt(1));
					item.setItem_name(result.getString(2));
					item.setQuantity_in_stock(result.getInt(3));
					item.setItem_price(result.getFloat(4));
				}	
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return item;
	}
	
	
	public List<Item> getItemsCostingGreaterThan(Double item_price) throws SQLException {
		List<Item> list = new ArrayList<Item>();
		
		Item item = null;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn= OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETITEMCOSTINGGREATERTHAN);
			stmt.setDouble(1, item_price);
			
			// execute query is only for reading data from the database 
			result = stmt.executeQuery();
			
				while(result!= null && result.next()) {
					item = new Item();
					
					item.setItem_id(result.getInt(1));
					item.setItem_name(result.getString(2));
					item.setQuantity_in_stock(result.getInt(3));
					item.setItem_price(result.getFloat(4));
					
					list.add(item);
				}	
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return list;
	}
	
	public List<Item> getItemsInStock() throws SQLException {
		List<Item> list = new ArrayList<Item>();
		
		Item item = null;
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		
		try {
			conn= OracleConnection.getConnection();
			stmt = conn.prepareStatement(OracleQueries.GETALLITEMSINSTOCK);
			
			// execute query is only for reading data from the database 
			result = stmt.executeQuery();
			
				while(result!= null && result.next()) {
					item = new Item();
					
					item.setItem_id(result.getInt(1));
					item.setItem_name(result.getString(2));
					item.setQuantity_in_stock(result.getInt(3));
					item.setItem_price(result.getFloat(4));
					
					list.add(item);
				}	
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			result.close();
			if(stmt!=null ) {
				stmt.close();
				
			}
			if(conn !=null) {
				conn.close();
			}
		}
		
		return list;
	}
}
