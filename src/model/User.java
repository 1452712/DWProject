package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User {
	
	public String name;
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452712?user=S_1452712&password=ItrHCVnJ";

	public User(String Id) {
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ProfileName FROM User WHERE UserId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	this.name = rs.getString("ProfileName");
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
