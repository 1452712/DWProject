package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Movie {
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452693?user=S_1452693&password=SEciWr5S";
	
	public class SingleMovie {
		public String ProductId;
		public String Name;
		public String Format;
		public String Edition;
		public double Price;
		public long Time;
		public String Rated;
		public String Director;
		public String Actors;
		public String Category;
	}
	
	static public SingleMovie getMovieById(String Id){
		
		Movie movie = new Movie();
		SingleMovie res = movie.new SingleMovie();
		
		try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT ProductId, Name, Format, Edition, Price,"
                		+ "Time, Rated, Director, Actors, Category FROM movie WHERE ProductId = " + Id;

                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()) {
                	res.ProductId = rs.getString("ProductId");
                	res.Name = rs.getString("name");
                	res.Format = rs.getString("Format");
                	res.Edition = rs.getString("Edition");
                	res.Price = rs.getDouble("Price");
                	res.Time = rs.getLong("Time");
                	res.Rated = rs.getString("Rated");
                	res.Director = rs.getString("Director");
                	res.Actors = rs.getString("Actors");
                	res.Category = rs.getString("Category");
                }

                rs.close();
                stmt.close();
                conn.close();
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
            e.printStackTrace();
        }
	 
	 return res;
	 
	}
	
	static public ArrayList<SingleMovie> getMovieByIdList(ArrayList<String> MovieId){
		
		ArrayList<SingleMovie> res = new ArrayList<SingleMovie>();
		
		try{
            Class.forName(dbDriverName).newInstance();

            Connection conn = DriverManager.getConnection(dbConn);

            if(conn!=null) {

    			Statement stmt = conn.createStatement();
    			Movie movie = new Movie();
    			
            	for(String Id: MovieId) {
            			
            			SingleMovie tmp = movie.new SingleMovie();
            			String sql = "SELECT ProductId, Name, Format, Edition, Price,"
            					+ "Time, Rated, Director, Actors, Category FROM movie WHERE ProductId = " + Id;

            			ResultSet rs = stmt.executeQuery(sql);
            			while(rs.next()) {
            				tmp.ProductId = rs.getString("ProductId");
            				tmp.Name = rs.getString("name");
            				tmp.Format = rs.getString("Format");
            				tmp.Edition = rs.getString("Edition");
            				tmp.Price = rs.getDouble("Price");
            				tmp.Time = rs.getLong("Time");
            				tmp.Rated = rs.getString("Rated");
            				tmp.Director = rs.getString("Director");
            				tmp.Actors = rs.getString("Actors");
            				tmp.Category = rs.getString("Category");
            				
            				res.add(tmp);
            			} 
            			
            			rs.close();   			
            	}

                stmt.close();
                conn.close();
            }
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e){
            e.printStackTrace();
        }
	 
	 return res;
	
	}

}
