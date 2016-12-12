package view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import controller.*;
/**
 * Servlet implementation class Test
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Test" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Search search = new Search();
		
		//test
		Result res = new Result(search.searchByTime(2001, 10, 0, 1));
		ArrayList<Movie.SingleMovie> list = new ArrayList<Movie.SingleMovie>();
		if(res != null) response.getWriter().append("searchByTime: success").append(Integer.toString(res.Count)).append("\r\n");
		if(res.MovieId != null) {
			list = Movie.getMovieByIdList(res.MovieId);
			for(Movie.SingleMovie item:list ) {
				response.getWriter().append("Result item: ")
					.append("\r\n ProductId: ").append(item.ProductId)
					.append("\r\n Name: ").append(item.Name)
				    .append("\r\n Format: ").append(item.Format)
					.append("\r\n Edition: ").append(item.Edition)
					.append("\r\n Discs: ").append(item.Discs)
					.append("\r\n Price: ").append(Double.toString(item.Price))
					.append("\r\n Time: ").append(Long.toString(item.Time))
					.append("\r\n Rated: ").append(item.Rated)
					.append("\r\n Director: ").append(item.Director)
					.append("\r\n Actors: ").append(item.Actors)
					.append("\r\n Style: ").append(item.Style)
					.append("\r\n Category: ").append(item.Category).append("\r\n");
			}
		}
		res = new Result(search.searchByActor(""));
		if(res != null) response.getWriter().append("searchByActor: success").append(Integer.toString(res.Count)).append("\r\n");

		res = new Result(search.searchByCategory(""));
		if(res != null) response.getWriter().append("searchByCategory: success").append(Integer.toString(res.Count)).append("\r\n");

		res = new Result(search.searchByDirector(""));
		if(res != null) response.getWriter().append("searchByDirector: success").append(Integer.toString(res.Count)).append("\r\n");

		res = new Result(search.searchByKeyword("",""));
		if(res != null) response.getWriter().append("searchByKeyword: success").append(Integer.toString(res.Count)).append("\r\n");

		res = new Result(search.searchByName(""));
		if(res != null) response.getWriter().append("searchByName: success").append(Integer.toString(res.Count)).append("\r\n");
	
		User user = new User("");
		if(user != null) response.getWriter().append("User: success").append(user.Name).append("\r\n");
		
		if(Comment.getCommentById("") != null){
			response.getWriter().append("getCommentById: success").append("\r\n");
		}
		if(Comment.getCommentByMovie("") != null){
			response.getWriter().append("getCommentByMovie: success").append("\r\n");
		}
		if(Comment.getCommentByUser("") != null){
			response.getWriter().append("getCommentByUser: success").append("\r\n");
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
