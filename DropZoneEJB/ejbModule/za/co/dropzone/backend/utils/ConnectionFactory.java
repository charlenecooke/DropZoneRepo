package za.co.dropzone.backend.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
    //static reference to itself
    private static ConnectionFactory instance = new ConnectionFactory();

    public static final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=DropZone"; //default port is 1433
    public static final String USER = "dropzone";
    public static final String PASSWORD = "F00tb@ll1";
    public static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
     
    //private constructor
    private ConnectionFactory() {

    }
     
    private Connection createConnection() {
    	
    	DataSource ds = null;
    	 
    	Context init;
		try {
			init = new InitialContext();
    	
    	ds = (DataSource) init.lookup("java:jboss/datasources/dropzone");
    	init.close();

		
		return ds.getConnection();
		
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
        return null;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }
}