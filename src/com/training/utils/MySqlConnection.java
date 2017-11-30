package com.training.utils;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class MySqlConnection {

	
	public static Connection getMySqlConnection(){
		Connection con=null;
		ClassLoader loader=   Thread.currentThread().getContextClassLoader();
	       
        InputStream stream =   loader.getResourceAsStream("DbConnection.properties");
        
        Properties props = new Properties();
        
        try {
			props.load(stream);
			
			Class.forName(props.getProperty("db.driverClass"));
			
			con= DriverManager.getConnection(
					   props.getProperty("db.url"),
					   props.getProperty("db.userName"),
					   props.getProperty("db.passWord")); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
return con;
	}
}
