package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.CategoryList;

public class Category {
	
	private static String dbDriverName = "com.mysql.jdbc.Driver"; 
	private static String dbConn = "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=";
	
	public static ArrayList<CategoryList> getCategoryList() {
		
		ArrayList<CategoryList> res = new ArrayList<CategoryList>();
		try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Category, CategoryId FROM category_dimension";

                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                	res.add(new CategoryList(rs.getString("Category"), rs.getString("CategoryId")));               	
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
		
		return res;
	}
	
	public static String getCategoryName(String id) {
		
		String res = new String();
		try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Category FROM category_dimension WHERE CategoryId = " + "\'"+id+ "\'";

                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                	res = rs.getString("Category");             	
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
		
		return res;
		
	}

}