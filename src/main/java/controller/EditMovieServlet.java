package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import model.Movie;
import controller.MovieHelper;

@WebServlet("/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditMovieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieHelper dao = new MovieHelper();
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movieToUpdate = dao.searchForMovieById(id);

        String newTitle = request.getParameter("title");
        String newGenre = request.getParameter("genre");
        LocalDate newReleaseDate = LocalDate.parse(request.getParameter("releaseDate"));

        movieToUpdate.setTitle(newTitle);
        movieToUpdate.setGenre(newGenre);
        movieToUpdate.setReleaseDate(newReleaseDate);

        dao.updateMovie(movieToUpdate);
        getServletContext().getRequestDispatcher("/ViewAllMoviesServlet").forward(request, response);
    }
}