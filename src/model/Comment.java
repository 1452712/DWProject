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
	private static String dbConn = "jdbc:mysql://10.60.42.203:8888/db_1452693?user=S_1452693&password=SEciWr5S";

	public class SingleComment {
		public String ReviewId;
		public String UserId;
		public String ProductId;
		public int Helpfulness;
		public double Score;
		public String Time;
		public String Summary;
		public String Text;
	}
	
	static public SingleComment getCommentById(String Id) {
		
		Comment comment = new Comment();
		SingleComment res = comment.new SingleComment();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM review WHERE ReviewId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                while(rs.next()) {
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getString("Time");
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
	

	static public ArrayList<SingleComment> getCommentByUser(String Id) {
		
		ArrayList<SingleComment> arr_res = new ArrayList<SingleComment>();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM review WHERE UserId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                Comment comment = new Comment();
	                while(rs.next()) {
	                	
	            		SingleComment res = comment.new SingleComment();
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getString("Time");
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
	
	static public ArrayList<SingleComment> getCommentByMovie(String Id) {
		
		ArrayList<SingleComment> arr_res = new ArrayList<SingleComment>();
		
		 try{
	            Class.forName(dbDriverName).newInstance();

	            Connection conn = DriverManager.getConnection(dbConn);

	            if(conn!=null) {
	                Statement stmt = conn.createStatement();
	                String sql = "SELECT ReviewId, UserId, ProductId, Helpfulness, Score, Time,"
	                		+ "Summary, Text FROM review WHERE ProductId = " + Id;

	                ResultSet rs = stmt.executeQuery(sql);
	                Comment comment = new Comment();
	                while(rs.next()) {
	                	
	            		SingleComment res = comment.new SingleComment();
	                	res.ReviewId = rs.getString("ReviewId");
	                	res.UserId = rs.getString("UserId");
	                	res.ProductId = rs.getString("ProductId");
	                	res.Helpfulness = rs.getInt("Helpfulness");
	                	res.Score = rs.getDouble("Score");
	                	res.Time = rs.getString("Time");
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
