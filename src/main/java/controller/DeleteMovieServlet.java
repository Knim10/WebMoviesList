package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Movie;

@WebServlet("/DeleteMovieServlet")
public class DeleteMovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteMovieServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieHelper mh = new MovieHelper();
        int id = Integer.parseInt(request.getParameter("id"));
        Movie toDelete = mh.searchForMovieById(id);
        mh.deleteMovie(toDelete);
        getServletContext().getRequestDispatcher("/ViewAllMoviesServlet").forward(request, response);
    }
}