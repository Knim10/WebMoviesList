package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.MovieHelper;
import model.Movie;

@WebServlet("/MovieNavServlet")
public class MovieNavServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MovieNavServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieHelper dao = new MovieHelper();
        String act = request.getParameter("doThisToMovie");

        String path = "/view-all-movies.jsp";

        if (act.equals("delete")) {
            try {
                Integer tempId = Integer.parseInt(request.getParameter("id"));
                Movie movieToDelete = dao.searchForMovieById(tempId);
                dao.deleteMovie(movieToDelete);
            } catch (NumberFormatException e) {
                System.out.println("Forgot to select a movie.");
            }
        } else if (act.equals("edit")) {
            try {
                Integer tempId = Integer.parseInt(request.getParameter("id"));
                Movie movieToEdit = dao.searchForMovieById(tempId);
                request.setAttribute("movieToEdit", movieToEdit);
                path = "/edit-movie.jsp";
            } catch (NumberFormatException e) {
                System.out.println("Forgot to select a movie.");
            }
        } else if (act.equals("add")) {
            path = "/add-movie.jsp";
        }

        getServletContext().getRequestDispatcher(path).forward(request, response);
    }
}