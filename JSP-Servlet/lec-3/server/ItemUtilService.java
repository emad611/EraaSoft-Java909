package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.Item;
public class ItemUtilService  {
	private DataSource datasource;
	
	public ItemUtilService(DataSource datasource) {
		this.datasource=datasource;
	}
	
	public List<Item>getItemsByIds()throws Exception
	{
	Connection connection=datasource.getConnection();
	Statement statement=connection.createStatement();
	  
	String Query="SELECT * FROM ITEM WHERE id IN(1,2)";
	  
	List<Item>items=new ArrayList();
	
ResultSet resultset=statement.executeQuery(Query);

while(resultset.next()) {
	Item item=new Item();
	
	item.setId(resultset.getInt("id"));
	item.setName(resultset.getNString("name"));
	item.setPrice(resultset.getDouble("price"));
	
	items.add(item);
}
return items;
	}
	
	public List<Item>getItemByName()throws Exception
	{
	Connection connection=datasource.getConnection();
	Statement statement=connection.createStatement();
	
	List<Item>items=new ArrayList();
	
	String Query="SELECT * FROM ITEM WHERE name LIKE'%i%'";
	
	ResultSet resultset=statement.executeQuery(Query);
	
	while(resultset.next()) {
		Item item=new Item();
		
		item.setId(resultset.getInt("id"));
		item.setName(resultset.getNString("name"));
		item.setPrice(resultset.getDouble("price"));
		
		items.add(item);
	}
	return items;
	}
	public List<Item>getItemsByPriceRange()throws Exception
	{
	Connection connection=datasource.getConnection();
	Statement statement=connection.createStatement();
	
	List<Item>items=new ArrayList();
	
	String Query="SELECT * FROM ITEM WHERE price > 20 AND price < 50";
	
	ResultSet resultset=statement.executeQuery(Query);
	
	while(resultset.next()) {
		Item item=new Item();
		
		item.setId(resultset.getInt("id"));
		item.setName(resultset.getNString("name"));
		item.setPrice(resultset.getDouble("price"));
		
		items.add(item);
	}
	return items;
	}
	public void SaveItem(List<Item>items) throws Exception
	{
		String query="INSERT INTO ITEM (id,name,price) VALUES (?,?,?)";
		Connection connection=datasource.getConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultset=statement.executeQuery(query);
		for(Item item:items) {
			((PreparedStatement) resultset).setInt(1,item.getId());
			
			((PreparedStatement) resultset).setString(1,item.getName());
			
			((PreparedStatement) resultset).setDouble(1,item.getPrice());
			
			
			statement.executeUpdate(query);
		}
		
	}

}



