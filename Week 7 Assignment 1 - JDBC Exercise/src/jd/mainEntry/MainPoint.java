package jd.mainEntry;

import java.sql.SQLException;
import java.util.List;

import jd.dao.ItemDAO;
import jd.model.Item;

public class MainPoint {

	public static void main(String[] args) throws SQLException {
		ItemDAO cd = new ItemDAO();
		List<Item> allItems = cd.getItemsInStock();
		
		allItems.forEach((item) -> System.out.println("Item ID: " + item.getItem_id() + " Item Name: " + item.getItem_name() + " Item Quantity: " + item.getQuantity_in_stock() + " Item Price: $" + item.getItem_price()));
	}

}
