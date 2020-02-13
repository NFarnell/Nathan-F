package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;

public class ItemsDaoMysql implements Dao<Items> {

	public static final Logger LOGGER = Logger.getLogger(ItemsDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public ItemsDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.246.8.35:3306/IMS";
		this.username = username;
		this.password = password;
	}

	public ItemsDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	Items itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long item_id = resultSet.getLong("item_id");
		String item_name = resultSet.getString("item_name");
		Long cost = resultSet.getLong("cost");
		return new Items(item_id, item_name, cost);
	}
	

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */

	@Override
	public List<Items> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from items");) {
			ArrayList<Items> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(itemFromResultSet(resultSet));
			}
			return items;
		} catch (SQLException e) {
			
		}
		return new ArrayList<>();
	}


	public Items create(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into items(item_name, cost) values('" + item.getItem_Name()
					+ "','" + item.getCost() + "')");

		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}



	public Items update(Items item) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update items set item_name ='" + item.getItem_Name() + "', cost ='"
					+ item.getCost() + "' where item_id =" + item.getItem_Id());
			
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from items where item_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}



}
