package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Movie;
import controller.MovieHelper;

@WebServlet("/ViewAllMoviesServlet")
public class ViewAllMoviesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewAllMoviesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieHelper dao = new MovieHelper();
        List<Movie> allMovies = dao.showAllMovies();
        request.setAttribute("allMovies", allMovies);
        getServletContext().getRequestDispatcher("/view-all-movies.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}