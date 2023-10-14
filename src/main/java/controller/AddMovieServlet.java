package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import model.Movie;

@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddMovieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String genre = request.getParameter("genre");
        LocalDate releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
        
        Movie movie = new Movie(title, genre, releaseDate);
        MovieHelper dao = new MovieHelper();
        dao.insertMovie(movie);

        getServletContext().getRequestDispatcher("/ViewAllMoviesServlet").forward(request, response);
    }
}