package com.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AppServlet", urlPatterns = "/movie")
public class AppServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      Getting data from textBox
        String searchContent = request.getParameter("searchContent");
        System.out.println(searchContent);

//      Creating movieService object that puts information about movies into list
        List<List<String>> list = MovieService.getListOfMovies(searchContent);

//      Sending list to the jsp file
        request.setAttribute("movielist", list);
        getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);
    }
}

