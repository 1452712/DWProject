package hive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class hiveClient
 */
@WebServlet("/hiveClient")
public class hiveClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String driverName = "com.cloudera.hive.jdbc4.HS2Driver";   
	Connection con;
	Statement stmt;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hiveClient() {
        super();
        try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // TODO Auto-generated constructor stub
      
		try {
			con = DriverManager.getConnection("jdbc:hive2://192.168.44.134:10000/default", "maria_dev", "maria_dev");
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		boolean resHivePropertyTest;
		
		try {
			resHivePropertyTest = stmt.execute("set hive.execution.engine=tez");
			
			response.getWriter().append("set result "+resHivePropertyTest+'\n');
			
		    String tableName = "drivers"; 
		   
		    //show tables
		    String sql = "show tables '" + tableName + "'";
		    
		    ResultSet res = stmt.executeQuery(sql);
		    if (res.next()) {
		    	response.getWriter().append(res.getString(1)+'\n');
		    }

		    //describe table
		    sql = "describe " + tableName;
	
		    res = stmt.executeQuery(sql);
		    while (res.next()) {
		    	response.getWriter().append(res.getString(1) + "\t" + res.getString(2)+'\n');
		    } 

		    String filepath = "/tmp/a.txt";
		    sql = "load data local inpath '" + filepath + "' into table " + tableName;
		   
//		     res = stmt.executeQuery(sql); 

		    // select * query
		    sql = "select * from " + tableName;
		    
		    res = stmt.executeQuery(sql);
		    while (res.next()) {
		    	response.getWriter().append(String.valueOf(res.getInt(1)) + "\t" + res.getString(2)+'\t'+res.getString(3)+'\t'
		    			+res.getString(4)+'\n');
		    }
		    
		    // regular hive query
		    sql = "select count(1) from " + tableName;
		    
		    res = stmt.executeQuery(sql);
		    while (res.next()) {
		    	response.getWriter().append(res.getString(1)+'\n');
		    }
		    
		   stmt.close();
		   con.close();
		   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}



   

   
    
   
