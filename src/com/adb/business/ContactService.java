package com.adb.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.adb.model.Contact;

public class ContactService {
	
	public List<Contact> getAllContacts(int userId){
		List<Contact> contacts = new ArrayList<Contact>();
		
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection(DBProperties.URL);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			String sql = "select * from addrbook.contacts where user_id=" + userId;
			System.out.println(sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("id"));
				contact.setFirstname(resultSet.getString("firstname"));
				contact.setLastname(resultSet.getString("lastname"));
				contact.setAddress(resultSet.getString("address"));
				contact.setEmail(resultSet.getString("email"));
				contact.setPhone(resultSet.getString("phone"));
				contact.setUserId(userId);
				contacts.add(contact);
			}

			return contacts;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return contacts;
		
	}
	
	public Contact getContact(int contactId){
	
		Connection connect = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection(DBProperties.URL);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			String sql = "select * from addrbook.contacts where id = " + contactId;

			System.out.println(sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getInt("id"));
				contact.setFirstname(resultSet.getString("firstname"));
				contact.setLastname(resultSet.getString("lastname"));
				contact.setAddress(resultSet.getString("address"));
				contact.setEmail(resultSet.getString("email"));
				contact.setPhone(resultSet.getString("phone"));
				contact.setUserId(resultSet.getInt("user_id"));
				return contact;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/*
	 * updating a existing contact
	 */
	public void update(Contact contact){
		System.out.println("Update() received a contact : " + contact);
		
		Connection connect = null;
		PreparedStatement  statement = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection(DBProperties.URL);

			String sql = "update addrbook.contacts  set firstname=?, lastname=?, email=?, address=?, phone=? where id=?";
			
			// Statements allow to issue SQL queries to the database
			statement = connect.prepareStatement(sql);
			statement.setString(1, contact.getFirstname());
			statement.setString(2, contact.getLastname());
			statement.setString(3, contact.getEmail());
			statement.setString(4, contact.getAddress());
			statement.setString(5, contact.getPhone());
			statement.setInt(6, contact.getId());
			
			System.out.println(sql);
			
			// execute insert SQL statement
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Adding a new contact
	 */
	public void insert(Contact contact){
		System.out.println("Save() received a contact : " + contact);
		
		Connection connect = null;
		PreparedStatement  statement = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection(DBProperties.URL);

			String sql = "insert into addrbook.contacts (firstname, lastname, email, address, phone, user_id) values (?, ?, ?, ?, ?, ?)";
			
			// Statements allow to issue SQL queries to the database
			statement = connect.prepareStatement(sql);
			statement.setString(1, contact.getFirstname());
			statement.setString(2, contact.getLastname());
			statement.setString(3, contact.getEmail());
			statement.setString(4, contact.getAddress());
			statement.setString(5, contact.getPhone());
			statement.setInt(6, contact.getUserId());
			
			System.out.println(sql);
			
			// execute insert SQL statement
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteContact(int contactId){
		System.out.println("Delete() received a contact : " + contactId);
	
		Connection connect = null;
		PreparedStatement  statement = null;

		try {

			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection(DBProperties.URL);

			String sql = "delete from addrbook.contacts  where id=?";
			
			// Statements allow to issue SQL queries to the database
			statement = connect.prepareStatement(sql);
			statement.setInt(1, contactId);
			
			System.out.println(sql);
			
			// execute insert SQL statement
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
