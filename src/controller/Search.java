package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.Result;

public class Search {
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452693?user=S_1452693&password=SEciWr5S";
	private static String dwDriverName = "com.cloudera.hive.jdbc4.HS2Driver";
	private static String dwConn = "jdbc:hive2://192.168.44.134:10000/default";
	
	public Result searchByTime(int Year, int Month, int Season, int Weekday){

		ArrayList<String[]> MovieId = new ArrayList<String[]>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Count, ProductId FROM Time_Dimension WHERE Year = " + Integer.toString(Year)
                + (Month == 0? "":("AND Month = " + Integer.toString(Month)))
                + (Season == 0? "":("AND Season = " + Integer.toString(Season)))
                + (Weekday == 0? "":("AND Weekday = " + Integer.toString(Weekday)));
                
                // execute the query & calculate the time
        		dbstart = System.currentTimeMillis();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.currentTimeMillis();
        		
                while(rs.next()) {
                	count += rs.getInt("Count");
                	MovieId.addAll((Collection<? extends String[]>) rs.getArray("ProductId"));
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
        
        //search in dw
        try {
        	Class.forName(dwDriverName);
        	Connection conn = DriverManager.getConnection(dwConn);

        	if(conn != null){
        		Statement stmt = conn.createStatement();
        		
        		String sql = "SELECT Count, ProductId FROM Time_Dimension WHERE Year = " + Integer.toString(Year)
                + (Month == 0? "":("AND Month = " + Integer.toString(Month)))
                + (Season == 0? "":("AND Season = " + Integer.toString(Season)))
                + (Weekday == 0? "":("AND Weekday = " + Integer.toString(Weekday)));
                
                // execute the query & calculate the time
        		dwstart = System.currentTimeMillis();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.currentTimeMillis();
        		
                while(rs.next()) {
                	count += rs.getInt("Count");
                	MovieId.addAll((Collection<? extends String[]>) rs.getArray("ProductId"));
                }

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
	}
	
//	public Result searchByName(String MovieName) {
//		
//	}
//
//	public Result searchByDirector(String DirectorName) {
//		
//	}
//	
//	public Result searchByActor(String ActorName) {
//		
//	}
//	
//	public Result searchByCategory(String Category) {
//		
//	}
//	
//	public Result searchByKeyword(String Attribute, String Value) {
//		
//	}
}
