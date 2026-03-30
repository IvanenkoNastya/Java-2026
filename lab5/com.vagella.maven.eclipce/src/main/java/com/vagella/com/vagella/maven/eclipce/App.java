package com.vagella.com.vagella.maven.eclipce;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	try {
	    	String url = "jdbc:postgresql://localhost:5432/Ivanenko";
	    	String uname = "postgres";
	    	String pass = "1111";
			Connection con = DriverManager.getConnection(url, uname, pass);
			
			java.sql.Statement st = con.createStatement();

			// create user (role)
			String roleName = "some_role";
			creteRole(st, roleName);
			
			
			// test
			ResultSet rs = st.executeQuery("SELECT * FROM hotel.person ORDER BY person_id ASC ");
			while (rs.next()) {
				System.out.println(rs.getInt("person_id") + ": " + rs.getString("name"));
			}
			
			
			
			
			
			
			
			rs.close();
			st.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return;
    }
}
