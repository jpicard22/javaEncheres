package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.encheres.dal.Settings;


public class JdbcTools {

	private static String url;
	private static String user;
	private static String password;
	
	private static Connection connection;

	//bloc d'initialisation statique
	static {
		try {
			Class.forName(Settings.getProperty("driverjdbc"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		url = Settings.getProperty("url");
		user = Settings.getProperty("user");
		password = Settings.getProperty("password");
		System.out.println("urldb: " + url);
		System.out.println("userdb: " + user);
		System.out.println("passworddb: " +password);
	}
	
	public static Connection getConnection() throws SQLException{
		if( connection != null ) return connection;
		
		return connection = DriverManager.getConnection(url, user, password);
	}
	
	public static void closeConnection() throws SQLException{
		if(connection!=null){
			connection.close();
			connection=null;
		}
	}
	
}


