<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<%--Begining of logo--%>
</body>
<div class="wrapper">
    <div class="logo">
        <div class="container">
            <p>The Movie Data Base</p>
            <p>${searchContent}</p>
        </div>
    </div>
</div>
<%--End of Logo--%>
<%--Begining of search bar--%>

<div class="search-container">
    <div class="search-element" >
        <h2>SEARCH A MOVIE</h2>

        <form method="get" method="post" action="/movie">
        <label for="movie-search-box"></label>
        <input type="text" class="form-control" placeholder="Search for a movie..." id="movie-search-box" name="searchContent">


        <div class="button-container">
            <button type="submit" class="search-button" >Search</button>
            <button type="button" class="clear-button" name="clearButton">Clear</button>
        </div>
        </form>
    </div>
</div>

<%--End of search container--%>
<%--Rsulult container--%>
<div class="wrapper-search">
    <div class="result-highlight">
        <img src="img/movie_poster.jpg" class="movie-poster">
        <div class="movie-info">
            <div class="movie-tittle">
                <h3>Dragon Ball Super: Super Hero</h3>
            </div>
            <div class="release-date">
                6 June 2022
            </div>
            <div class="movie-description">
                <p>The Red Ribbon Army, an evil organization that was once destroyed by Goku in the past, has been reformed by a
                    group of people who have created new and mightier Androids, Gamma 1 and Gamma 2, and seek vengeance against Goku and his family.</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>