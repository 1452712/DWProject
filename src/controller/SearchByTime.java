package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Search;
import model.Result;
import model.Movie;

/**
 * Servlet implementation class SearchByTime
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchByTime" })
public class SearchByTime extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByTime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year_temp = (String) request.getParameter("year");
        String month_temp = (String) request.getParameter("month");
        String weekday_temp = (String) request.getParameter("weekday");
        String season_temp = (String) request.getParameter("season");       
        //response.getWriter().append(year_temp+month_temp+weakday_temp+season_temp);
        
        int year = (year_temp != null)?Integer.parseInt(year_temp) : 0;
        int month = (month_temp != null)?Integer.parseInt(month_temp) : 0;
        int weekday = (weekday_temp != null)?Integer.parseInt(weekday_temp) : 0;
        int season = (season_temp != null)?Integer.parseInt(season_temp) : 0;
        
        Result result = new Result(Search.searchByTime(year, month, season, weekday));
        
        HttpSession session = request.getSession(true);
        session.setAttribute("Count", result.Count);
        session.setAttribute("DBTime", (result.DBTime > 0)?result.DBTime:0);
        session.setAttribute("DWTime", (result.DWTime > 0)?result.DWTime:0);
        
    	String[] month_map = new String[12];        
        month_map[0] = "Jan."; month_map[1] = "Feb."; month_map[2] = "Mar."; month_map[3] = "Apr.";
        month_map[4] = "May."; month_map[5] = "Jun."; month_map[6] = "Jul."; month_map[7] = "Aug.";
        month_map[8] = "Sept."; month_map[9] = "Oct."; month_map[10] = "Nov."; month_map[11] = "Dec.";
        
    	String[] weekday_map = new String[7];
    	weekday_map[0] = "Mon."; weekday_map[1] = "Tues."; weekday_map[2] = "Wed.";
    	weekday_map[3] = "Thur."; weekday_map[4] = "Fri."; weekday_map[5] = "Sat."; weekday_map[6] = "Sun.";
    	
        String[] season_map = new String[4];
        season_map[0] = "Spring"; season_map[1] = "Summer"; season_map[2] = "Autumn"; season_map[3] = "Winter";
        
        String search_condition = "Time\r\n" + "Year: " + year_temp 
        		+ (month != 0? ", Month: " + month_map[month - 1] : "")
        		+ (weekday != 0? ", Weekday: " + weekday_map[weekday - 1] : "")
        		+ (season != 0? ", Season: " + season_map[season - 1] : "");
        session.setAttribute("SearchCondition", search_condition);

        response.sendRedirect("./ResultSimple");
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
