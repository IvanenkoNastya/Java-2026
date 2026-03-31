package com.vagella.com.vagella.maven.eclipce;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class App {
	/*public static void printUsage() {
		System.out.println("Usage:");
		System.out.println("Parameters required:");
		System.out.println("1) Path to .properties file");
	}
	
	public static String getPropertiesFileName(String[] args) {
		return args[0];
	}*/
	
	public static Properties readConfiguration(String filename) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(filename));
		} catch (IOException e) {
			System.out.println("Error, " + e.getMessage());
		}
		return properties;
	}
	
    public static void main(String[] args) {
    	try {
    		/*if (args.length < 1) {
    			printUsage();
    			return;
    		}
    		String propertiesFileName = getPropertiesFileName(args);
    		Properties properties = PropertiesWrapper.loadProperties(propertiesFileName);
    		*/
    		
    		String configFilename = "./resources/config.properties";
    		Properties properties = readConfiguration(configFilename);
			System.out.println("properties: " + properties);
			
	    	//String url = "jdbc:postgresql://localhost:5432/Ivanenko";
	    	//String uname = "postgres";
	    	//String pass = "1111";
	    	String url = properties.getProperty("database.url");
	    	String uname = properties.getProperty("username");
	    	String pass = properties.getProperty("password");
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			java.sql.Statement st = con.createStatement();
			
			String roleName = "some_role";
			creteRole(st, roleName);
			String usersTableName = "authorisation";
			createTableAuthorise(st, usersTableName, roleName);
			
			// add users
			addUserToTable(st, usersTableName, "user1", "password", roleName);
			addUserToTable(st, usersTableName, "user2", "password", roleName);
			addUserToTable(st, usersTableName, "user3", "password333", roleName);
			addUserToTable(st, usersTableName, "simple_user", "333", roleName);
			addUserToTable(st, usersTableName, "maple", "leaf", roleName);
			addUserToTable(st, usersTableName, "silver", "gold", roleName);
			
			// show users table
			System.out.println("-- users table:");
			ResultSet rs = st.executeQuery("SELECT * FROM hotel.authorisation ORDER BY id_user ASC ");
			while (rs.next()) {
				System.out.println(rs.getInt("id_user") + ", " 
						+ rs.getString("username").trim() + ", " 
						+ rs.getString("hash"));
			}
			
			// authorise users
			System.out.println("-- authorise users:");
			printAuthoriseUser(st, usersTableName, "silver", "leaf", roleName); // wrong one
			printAuthoriseUser(st, usersTableName, "maple", "leaf", roleName); // correct one

			System.out.println("-- CRUD:");
			// create
			System.out.println("-- create:");
			
			// read
			System.out.println("-- read:");
			readEntity(con, "Country", 2);
			readEntity(con, "Country", 3);
			readEntity(con, "Country", 22);
			readEntity(con, "CountryLanguage", 2);
			
			// update
			System.out.println("-- update:");
			updateEntity(con, "Country", 1, "PolyticalSystem", "new polytical system");
			
			// delete
			System.out.println("-- delete:");
			deleteEntity(con, "CountryLanguage", 35);
			
			// search
			System.out.println("-- search:");
			String sqlQuerySelectCountry = "SELECT * FROM hotel.\"Country\" WHERE \"CodeISO\" = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuerySelectCountry);
			preparedStatement.setObject(1, "CA", Types.VARCHAR);
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("idCountry") + ", " + rs.getString("Name"));
			}

			preparedStatement.setString(1, "MX");
			rs = preparedStatement.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				System.out.println(rs.getInt("idCountry") + ", " + rs.getString("Name"));
			}
			System.out.println("-- meda data:");
			System.out.println("amount of columns: " + metaData.getColumnCount());
			System.out.println("first column name: " + metaData.getColumnName(1));
			System.out.println("first column type: " + metaData.getColumnTypeName(1));
			System.out.println("third column type: " + metaData.getColumnTypeName(3));

			System.out.println("-- the end --");
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void creteRole(java.sql.Statement st, String roleName) {
    	try {
			st.execute(
				"DROP ROLE IF EXISTS " + roleName + ";\r\n"
				+ "\r\n"
				+ "CREATE ROLE " + roleName + " WITH\r\n"
				+ "  LOGIN\r\n"
				+ "  NOSUPERUSER\r\n"
				+ "  INHERIT\r\n"
				+ "  NOCREATEDB\r\n"
				+ "  NOCREATEROLE\r\n"
				+ "  NOREPLICATION\r\n"
				+ "  NOBYPASSRLS;"
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return;
    }
    
    public static void createTableAuthorise(java.sql.Statement st, String tableName, String roleName) {
    	try {
			st.execute(
				"DROP TABLE IF EXISTS hotel." + tableName + ";\r\n"
				+"CREATE TABLE hotel." + tableName + "\r\n"
				+ "(\r\n"
				+ "    id_user integer PRIMARY KEY generated always as identity,\r\n"
				+ "    username character(60),\r\n"
				//+ "    salt character(20),\r\n"
				+ "    hash integer\r\n"
				//+ "    PRIMARY KEY (id_user)\r\n"
				+ ");\r\n"
				+ "\r\n"
				+ "ALTER TABLE IF EXISTS hotel.dfhg\r\n"
				+ "    OWNER to " + roleName + ";"
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return;
    }

    public static void addUserToTable(
    		java.sql.Statement st, 
    		String tableName,
    		String username,
    		String password,
    		String roleName
    		) {
    	try {
    		int hash = (password + username).hashCode();
			st.execute(
				"INSERT INTO hotel." + tableName + " (username, hash)\r\n"
				+ "VALUES (\r\n"
				+ "'" + username + "',\r\n"
				+ "'" + hash + "'\r\n"
				+ ")"
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return;
    }
    
    public static boolean authoriseUser(
    		java.sql.Statement st,
    		String tableName,
    		String username,
    		String password,
    		String roleName
    		) {
    	try {
    		int hash = (password + username).hashCode();
    		ResultSet rs = st.executeQuery(
				"SELECT * FROM hotel.authorisation\r\n"
				+ "WHERE username = '" + username + "'"
			);
    		boolean res = false;
    		rs.next();
    		if (hash == rs.getInt("hash")) {
    			res = true;
    		}
    		rs.close();
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return false;
    }
    
    public static void printAuthoriseUser(
    		java.sql.Statement st,
    		String tableName,
    		String username,
    		String password,
    		String roleName
    		) {
    	if (authoriseUser(st, tableName, username, password, roleName)) {
			System.out.println("user " + username + " is authorised successfully");
    	} else {
			System.out.println("authorisation is denied for the user " + username);
    	}
    	return;
    }
    
    public static String getIdName(String tableName) {
    	switch (tableName) {
			case ("Country"):
	    		return "idCountry";
			case ("CountryLanguage"):
				return "idLanguage";
			default:
				return "id";
		}
    }
    
    public static void createEntity(
    		Connection con,
    		String tableName,
    		String propertyName,
    		String value
    		) { // INSERT
    	/*try {
    		String sqlQueryInsert = "INSERT INTO hotel.\"" + tableName + "\" (\"" + propertyName + "\") "
    				+ "VALUES (\"" + value + "\")";
    		java.sql.Statement st = con.createStatement();
    		st.executeUpdate(sqlQueryInsert, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement preparedStatement = con.prepareStatement(sqlQueryInsert, Statement.RETURN_GENERATED_KEYS);
			//preparedStatement.setString(1, value);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
    	
    	/*if (preparedStatement.executeUpdate() > 0) {
			ResultSet rs = preparedStatement.getGeneratedKeys();
			while (rs.next()) {
				System.out.println(tableName + ": id="+ rs.getInt(1) + ", " + rs.getString(2));
			}
			rs.close();
		}*/
		
    }
    
    public static void readEntity(
    		Connection con,
    		String tableName,
    		int id
    		) { // SELECT
    	try {
    		String sqlQuerySelect = "SELECT * FROM hotel.\"" + tableName + "\" WHERE \"" + getIdName(tableName) + "\" = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sqlQuerySelect);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(tableName + ": id=" + rs.getInt(1) + ", " + rs.getString(2));
			}
    		rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void updateEntity(
    		Connection con,
    		String tableName,
    		int id,
    		String propertyName,
    		String value
    		) { // UPDATE
    	try {
    		String sqlQueryUpdate = "UPDATE hotel.\"" + tableName + "\" "
    				+ "SET \"" + propertyName + "\" = ? "
    				+ "WHERE \"" + getIdName(tableName) + "\" = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sqlQueryUpdate);
			preparedStatement.setString(1, value);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			System.out.println("Update of the table " + tableName + " is successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void deleteEntity(
    		Connection con,
    		String tableName,
    		int id
    		) { // DELETE
    	try {
    		String sqlQueryUpdate = "DELETE FROM hotel.\"" + tableName + "\" "
    				+ "WHERE \"" + getIdName(tableName) + "\" = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sqlQueryUpdate);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("Delete of entity with id:" + id + " in table " + tableName + " is successful");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}
