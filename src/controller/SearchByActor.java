package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Movie;
import model.Result;

/**
 * Servlet implementation class SearchByActor
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchByActor" })
public class SearchByActor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByActor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = (String) request.getParameter("type");
        String name = (String) request.getParameter("actor");
        
        Result result = new Result(Search.searchByActor(type, name));
        ArrayList<Movie.SingleMovie> movie_list = new ArrayList<Movie.SingleMovie>();
        movie_list = Movie.getMovieByIdList(result.MovieId);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("Count", result.Count);
        session.setAttribute("DBTime", (result.DBTime > 0)?result.DBTime/1000:0);
        session.setAttribute("DWTime", (result.DWTime > 0)?result.DWTime/1000:0);
        session.setAttribute("MovieList",movie_list);
        session.setAttribute("SearchCondition", "Actor" + " (" + type + ")" + ": " + name);
        
        response.sendRedirect("./ResultWithDetail.jsp");
        //getRequestDispatcher("ResultWithDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
