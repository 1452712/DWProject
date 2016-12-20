package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Result;
import controller.Search;

import model.Result;

/**
 * Servlet implementation class SearchComprehensive
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchComprehensive" })
public class SearchComprehensive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchComprehensive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int count = 0;
		long dbtime = 0;
		long dwtime = 0;
		String search_condition = "COMPREHENSIVE SEARCHING";
		
		// searching in five conditions
		int index = 0;
		String attribute_name = "attribute1_";
		String value_name = "value1_";
		String attribute = (String) request.getParameter(attribute_name + Integer.toString(index));
        String value = (String) request.getParameter(value_name + Integer.toString(index));
        while(attribute != null && value != null) {
        	switch(attribute) {
        	case "1":
        		int year = Integer.parseInt((String) request.getParameter(value_name + Integer.toString(index) + "_0"));
                int month = Integer.parseInt((String) request.getParameter(value_name + Integer.toString(index) + "_1"));
                int weekday = Integer.parseInt((String) request.getParameter(value_name + Integer.toString(index) + "_2"));
                int season = Integer.parseInt((String) request.getParameter(value_name + Integer.toString(index) + "_3"));
                Result result1 = new Result(Search.searchByTime(year, month, season, weekday));
                count += result1.Count;
                dbtime += result1.DBTime;
                dwtime += result1.DWTime;
                break;
        	case "2":
        		Result result2  = new Result(Search.searchByName(value));
                count += result2.Count;
                dbtime += result2.DBTime;
                dwtime += result2.DWTime;
                break;
        	case "3":
        		Result result3  = new Result(Search.searchByDirector(value));
                count += result3.Count;
                dbtime += result3.DBTime;
                dwtime += result3.DWTime;
                break;
        	case "4":
        		String type = (String) request.getParameter(value_name + Integer.toString(index) + "_0");
        		String name = (String) request.getParameter(value_name + Integer.toString(index) + "_1");
        		Result result4  = new Result(Search.searchByActor(type, name));
                count += result4.Count;
                dbtime += result4.DBTime;
                dwtime += result4.DWTime;
                break;
        	case "5":
        		Result result5  = new Result(Search.searchByCategory(value));
                count += result5.Count;
                dbtime += result5.DBTime;
                dwtime += result5.DWTime;
                break;
            default:
                break;    	
        	}
        	index += 1;
    		attribute = (String) request.getParameter(attribute_name + Integer.toString(index));
            value = (String) request.getParameter(value_name + Integer.toString(index));
        }
        
        // searching in other conditions
		index = 0;
		attribute_name = "attribute2_";
		value_name = "value2_";
		attribute = (String) request.getParameter(attribute_name + Integer.toString(index));
        value = (String) request.getParameter(value_name + Integer.toString(index));
        while(attribute != null && value != null) {
        	if(attribute == "0") continue;
        	Result result  = new Result(Search.searchByKeyword(attribute, value));
            count += result.Count;
            dbtime += result.DBTime;
            dwtime += result.DWTime;
            
        	index += 1;
    		attribute = (String) request.getParameter(attribute_name + Integer.toString(index));
            value = (String) request.getParameter(value_name + Integer.toString(index));
        }
		
        HttpSession session = request.getSession(true);
        session.setAttribute("Count", count);
        session.setAttribute("DBTime", (dbtime > 0)?dbtime/1000:0);
        session.setAttribute("DWTime", (dwtime > 0)?dwtime/1000:0);

        session.setAttribute("SearchCondition", search_condition);

        response.sendRedirect("./Result.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
