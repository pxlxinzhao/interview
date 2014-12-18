package com.patrick.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/interview";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public void printSTH(){
		   System.out.println("Test DI");
	   }
	   
	   public void saveUser(String username, String passwd) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{

	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "INSERT INTO users (username, passwd) VALUES ('"+username+"','"+passwd+"')";
	      stmt.execute(sql);
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	  }
 }
}

