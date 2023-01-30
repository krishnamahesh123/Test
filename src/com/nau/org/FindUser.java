package com.nau.org;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class FindUser {
	
	public String id;
	public String username;

	  public  FindUser(String id, String username) {
	    this.id = id;
	    this.username = username;
	    
	  }
	  
	  public static FindUser fetch(String id) {
		    Statement stmt = null;
		    FindUser user = null;
		    try {
		      Connection cxn = ConnectDB.connection();
		      stmt = cxn.createStatement();
		      System.out.println("connected to database");

		      String query = "select * from users where id = '" + id + "' limit 1";
		      ResultSet rs = stmt.executeQuery(query);
		      if (rs.next()) {
		        String user_id = rs.getString("user_id");
		        String username = rs.getString("username");
		        user = new FindUser(user_id, username);
		      }
		      cxn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		      System.err.println(e.getClass().getName()+": "+e.getMessage());
		    } finally {
		      return user;
		    }
		  }
	
	
}
