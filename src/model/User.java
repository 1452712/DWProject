package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controller.String;

public class User {
	
	public String Name;
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452693?user=S_1452693&password=SEciWr5S";
	
	public User(String Id) {
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ProfileName FROM user WHERE UserId = " + Id;

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
