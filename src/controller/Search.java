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
	private static String dbConn = "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=";
	private static String dwDriverName = "com.cloudera.hive.jdbc4.HS2Driver";
	private static String dwConn = "jdbc:hive2://192.168.44.134:10000/default";
	
	public static Result searchByTime(int Year, int Month, int Season, int Weekday){
		
		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Count, TimeId FROM time_dimension WHERE Year = " + Integer.toString(Year)
                + (Month == 0? "":(" AND Month = " + Integer.toString(Month)))
                + (Season == 0? "":(" AND Season = " + Integer.toString(Season)))
                + (Weekday == 0? "":(" AND Weekday = " + Integer.toString(Weekday)));
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
                while(rs.next()) {
                	count += rs.getInt("Count");
                	Statement stmt2 = conn.createStatement();
                	String sql2 = "SELECT TimeProductId FROM time_movie_list WHERE TimeId = \'" + rs.getString("TimeId")+"\'";
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	while(rs2.next()){
                		MovieId.add(rs2.getString("TimeProductId"));
                	}
                	rs2.close();
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
        		
        		String sql = "SELECT count, timeid FROM time_dimension WHERE year = " + Integer.toString(Year)
                + (Month == 0? "":(" AND month = " + Integer.toString(Month)))
                + (Season == 0? "":(" AND season = " + Integer.toString(Season)))
                + (Weekday == 0? "":(" AND weekday = " + Integer.toString(Weekday)));
                
                // execute the query & calculate the time
        		dwstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.nanoTime();

        		rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
	}
	
	public static Result searchByName(String MovieName) {
		
		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Count, NameId FROM name_dimension WHERE Name like \'%" + MovieName + "%\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
        		while(rs.next()) {
                	count += rs.getInt("Count");
                	Statement stmt2 = conn.createStatement();
                	String sql2 = "SELECT NameProductId FROM name_movie_list WHERE NameId = \'" + rs.getString("NameId") + "\'";
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	while(rs2.next()){
                		MovieId.add(rs2.getString("NameProductId"));
                	}
                	rs2.close();
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
        		
        		String sql = "SELECT count, nameid FROM name_dimension WHERE name like \'%" + MovieName + "%\'";
                
                // execute the query & calculate the time
        		dwstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.nanoTime();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}

	public static Result searchByDirector(String DirectorName) {

		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Count, DirectorId FROM director_dimension WHERE DirectorName like \'%" + DirectorName + "%\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
        		while(rs.next()) {
                	count += rs.getInt("Count");
                	Statement stmt2 = conn.createStatement();
                	String sql2 = "SELECT DirectorProductId FROM director_movie_list WHERE DirectorId = \'" + rs.getString("DirectorId") + "\'";
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	while(rs2.next()){
                		MovieId.add(rs2.getString("DirectorProductId"));
                	}
                	rs2.close();
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
        		
        		String sql = "SELECT count, directorId FROM director_dimension WHERE directorname like \'%" + DirectorName + "%\'";
                
                // execute the query & calculate the time
        		dwstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.nanoTime();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}
	
	public static Result searchByActor(String Attribute, String ActorName) {	

		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		String productid="STActorProductId";
        String count_para = "StarringCount";
        String table_para = "starring_movie_list";
        String actor_para = "STActorId";
        if (Attribute.equals("supporting")){
        	productid="SUActorProductId";
        	count_para = "SupportingCount";
        	table_para = "supporting_movie_list";
        	actor_para = "SUActorId";
        }
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();

                String sql = "SELECT " + count_para + ", ActorId FROM actor_dimension WHERE ActorName like \'%" + ActorName + "%\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
        		while(rs.next()) {
                	count += rs.getInt(count_para);
                	Statement stmt2 = conn.createStatement();
                	String sql2 = "SELECT "+ productid +" FROM " + table_para + " WHERE " + actor_para + " = \'" + rs.getString("ActorId") + "\'";
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	while(rs2.next()){
                		MovieId.add(rs2.getString(productid));
                	}
                	rs2.close();
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
        		
        		String sql = "SELECT " + count_para.toLowerCase() + ", actorId FROM actor_dimension WHERE actorName like \'%" + ActorName + "%\'";
                
                // execute the query & calculate the time
        		dwstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.nanoTime();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}
	
	public static Result searchByCategoryId(String CategoryId) {
		
		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT CategoryProductId FROM category_movie_list WHERE CategoryId = " + "\'"+CategoryId+"\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
        		while(rs.next()) {
                	count += 1;
            		MovieId.add(rs.getString("CategoryProductId"));
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
        		
        		String sql = "SELECT categoryproductid FROM category_movie_list WHERE categoryid = " + CategoryId;
                
                // execute the query & calculate the time
        		dwstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.nanoTime();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}
	
	public static Result searchByCategory(String Category) {
		
		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT Count, CategoryId FROM category_dimension WHERE Category = \'" + Category + "\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
        		while(rs.next()) {
                	count += rs.getInt("Count");
                	Statement stmt2 = conn.createStatement();
                	String sql2 = "SELECT CategoryProductId FROM category_movie_list WHERE CategoryId = \'" + rs.getString("CategoryId") + "\'";
                	ResultSet rs2 = stmt2.executeQuery(sql2);
                	while(rs2.next()){
                		MovieId.add(rs2.getString("CategoryProductId"));
                	}
                	rs2.close();
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
        		
        		String sql = "SELECT count, categoryid FROM category_dimension WHERE category = \'" + Category + "\'";
                
                // execute the query & calculate the time
        		dwstart = System.currentTimeMillis();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.currentTimeMillis();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}
	
	public static Result searchByKeyword(String Attribute, String Value) {

		ArrayList<String> MovieId = new ArrayList<String>();
		long dbstart = 0, dbend = 0, dwstart = 0, dwend = 0;
		int count = 0;
		
		// search in db
        try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT ProductId FROM movie WHERE " + Attribute + " like \'%" + Value + "%\'";
                
                // execute the query & calculate the time
        		dbstart = System.nanoTime();
                ResultSet rs = stmt.executeQuery(sql);
        		dbend = System.nanoTime();
        		
                while(rs.next()) {
                	count += 1;
                	MovieId.add(rs.getString("ProductId"));
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

                String sql = "SELECT productid FROM movie WHERE " + Attribute.toLowerCase() + " like \'%" + Value + "%\'";
                
                // execute the query & calculate the time
        		dwstart = System.currentTimeMillis();
                ResultSet rs = stmt.executeQuery(sql);
        		dwend = System.currentTimeMillis();

                rs.close();
                stmt.close();
                conn.close();
        	}
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } 
		
		return new Result(dbend-dbstart,dwend-dwstart,count,MovieId);
		
	}
}
