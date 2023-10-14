package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Movie;
import model.MovieNight;


/**
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/editListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListDetailsHelper ldh = new ListDetailsHelper();
		MovieHelper mh = new MovieHelper();
		MovieNightHelper mnh = new MovieNightHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listToUpdate = ldh.searchForListDetailsById(tempId);
		
		String newListname = request.getParameter("listName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String shopperName = request.getParameter("shopperName");
		//find our add the new shopper
		MovieNight newMovieNight = mnh.findMovieNight(shopperName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		}
		catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
			//items are selected in list to add
			String[] selectedMovies = request.getParameterValues("allItemsToAdd");
			List<Movie> selectedMoviesInList = new ArrayList<Movie>();
			
			for(int i = 0; i < selectedMovies.length; i++) {
				System.out.println(selectedMovies[i]);
				Movie c = mh.searchForMovieById(Integer.parseInt(selectedMovies[i]));
				selectedMoviesInList.add(c);
			}
			listToUpdate.setListOfItems(selectedMoviesInList);
		}
		catch(NullPointerException ex) {
			//no items selected in list - set to an empty list
			List<Movie> selectedItemsInList = new ArrayList<Movie>();
			listToUpdate.setListOfItems(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListname);
		//listToUpdate.setTripDate(ld);
		listToUpdate.setMovieNight(newMovieNight);
		
		ldh.updateList(listToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
	}

}
