package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	public String Name;
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn ="jdbc:mysql://127.0.0.1:3306/sys?user=root&password=";
	
	public User(String Id) {
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ProfileName FROM user WHERE UserId = " + "\'"+ Id+ "\'";

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	this.Name = rs.getString("ProfileName");
	                }

	                rs.close();
	                stmt.close();
	                conn.close();
	            }
	        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e){
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}
}
