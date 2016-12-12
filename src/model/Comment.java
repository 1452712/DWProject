package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Comment {

public String name;
	
	private static String dbDriverName = "com.mysql.jdbc.Driver";
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452712?user=S_1452712&password=ItrHCVnJ";

	public class SingleComment {
		public String ReviewId;
		public String UserId;
		public String ProductId;
		public int Helpfulness;
		public double Score;
		public long Time;
		public String Summary;
		public String Text;
	}
	
	public SingleComment getCommentById(String Id) {
		
		SingleComment res = new SingleComment();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM Review WHERE ReviewId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getLong("Time");
	                	res.Summary = rs.getString("Summary");
	                	res.Text = rs.getString("Text");
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
		 
		 return res;
	}
	

	public ArrayList<SingleComment> getCommentByUser(String Id) {
		
		ArrayList<SingleComment> arr_res = new ArrayList<SingleComment>();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM Review WHERE UserId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	
	            		SingleComment res = new SingleComment();
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getLong("Time");
	                	res.Summary = rs.getString("Summary");
	                	res.Text = rs.getString("Text");
	                	
	                	arr_res.add(res);
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
		 
		 return arr_res;
	}
	
	public ArrayList<SingleComment> getCommentByMovie(String Id) {
		
		ArrayList<SingleComment> arr_res = new ArrayList<SingleComment>();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM Review WHERE ProductId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	
	            		SingleComment res = new SingleComment();
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getLong("Time");
	                	res.Summary = rs.getString("Summary");
	                	res.Text = rs.getString("Text");
	                	
	                	arr_res.add(res);
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
		 
		 return arr_res;
	}
}
