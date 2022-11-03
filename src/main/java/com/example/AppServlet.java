package com.example;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AppServlet", urlPatterns = "/movie")
public class AppServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//      Getting data from textBox
        String searchContent = request.getParameter("searchContent");
        System.out.println(searchContent);

//      List of lists with information about movies
//        List<List<String>> list = new ArrayList<>();

//      Creating movieService object that puts information about movies into list
        MovieService movieService = new MovieService();
//        movieService.movieListCreator(list, searchContent);


        List<List<String>> list = movieService.getListOfMovies(searchContent);


//      Sending list to the jsp file
        request.setAttribute("movielist", list);
        getServletContext().getRequestDispatcher("/search.jsp").forward(request, response);




    }
}

