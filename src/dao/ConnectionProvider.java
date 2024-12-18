package dao;

import java.sql.*;


public class ConnectionProvider {
    private static final String DB_NAME = "attendanceJframebd";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "admin123";
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL+"?useSSL=false", DB_USERNAME, DB_PASSWORD);
            if(!databaseExists(con, DB_NAME)){
                createDatabase(con, DB_NAME);
            }
            con = DriverManager.getConnection(DB_URL+DB_NAME+"?useSSL=false", DB_USERNAME, DB_PASSWORD);
            return con;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean databaseExists(Connection con, String dbName) throws Exception{
        Statement stmt = con.createStatement();
        return stmt.executeQuery("SHOW DATABASES LIKE '" + dbName + "'").next();
    }
    
    private static void createDatabase(Connection con, String dbName) throws Exception{
        Statement stmt = con.createStatement();
        stmt.executeUpdate("CREATE DATABASE "+dbName);
        System.out.println("Database '"+dbName+"' created successfully.");
    }
}
