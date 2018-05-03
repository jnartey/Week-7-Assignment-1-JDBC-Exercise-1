package jd.utils;

public class OracleQueries {

	public final static String GETITEMBYID = "SELECT * FROM ITEM "
			+ "WHERE id = ?";
	
	public final static String GETITEMCOSTINGGREATERTHAN = "SELECT * FROM ITEM "
			+ "WHERE price > ?";
	
	public final static String GETALLITEMSINSTOCK = "SELECT * FROM ITEM "
			+ "WHERE quantity_in_stock > 0";
	
	public final static String SAVEITEM = "INSERT INTO ITEM "
			+ "(name, price) "
			+ "values (?,?)";
	
	public final static String DELETEITEM = "DELETE FROM ITEM "
			+ "WHERE id = ?";
}
