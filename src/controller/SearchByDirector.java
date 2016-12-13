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
 * Servlet implementation class SearchByDirector
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SearchByDirector" })
public class SearchByDirector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByDirector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String name = (String) request.getParameter("director");
        
        Result result = new Result(Search.searchByDirector(name));
        ArrayList<Movie.SingleMovie> movie_list = new ArrayList<Movie.SingleMovie>();
        movie_list = Movie.getMovieByIdList(result.MovieId);
        
        HttpSession session = request.getSession(true);
        session.setAttribute("Count", result.Count);
        session.setAttribute("DBTime", result.DBTime);
        session.setAttribute("DWTime", result.DWTime);
        session.setAttribute("MovieList",movie_list);
        session.setAttribute("SearchCondition", "Director: " + name);
        
        response.sendRedirect("/ResultDetail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
