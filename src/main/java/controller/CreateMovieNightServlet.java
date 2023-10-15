package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;
import model.MovieNight;

@WebServlet("/createMovieNight")
public class CreateMovieNightServlet extends HttpServlet {
    
    private MovieHelper movieHelper = new MovieHelper();
    private MovieNightHelper movieNightHelper = new MovieNightHelper();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Movie> movies = movieHelper.getAllMovies();
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/create-movienight.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] selectedMovieIds = request.getParameterValues("selectedMovies");
        String movieNightName = request.getParameter("movieNightName");
        
        if (selectedMovieIds == null || selectedMovieIds.length == 0 || movieNightName == null || movieNightName.trim().isEmpty()) {
            
            request.setAttribute("errorMessage", "Please select at least one movie and enter a movie night name.");
            doGet(request, response);
            return;
        }

        MovieNight movieNight = new MovieNight(movieNightName);

        for (String movieIdString : selectedMovieIds) {
            int movieId = Integer.parseInt(movieIdString);
            Movie movie = movieHelper.getMovieById(movieId);
            movie.setMovieNight(movieNight);
            movieNight.getMovies().add(movie);
        }

        movieNightHelper.insertMovieNight(movieNight);
        
        response.sendRedirect("index.jsp");
    }
}