<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
    <link rel="stylesheet" href="styles.css">

</head>
<body>
<%--Begining of logo--%>
</body>
<div class="wrapper">
    <div class="logo">
        <div class="container">
            <p>The Movie Data Base</p>
        </div>
    </div>
</div>
<%--End of Logo--%>
<%--Begining of search bar--%>

<div class="search-container">
    <div class="search-element" >
        <h2>SEARCH A MOVIE</h2>

        <form method="post" action="${pageContext.request.contextPath}/movie">
        <label for="movie-search-box"></label>
        <input type="text" class="form-control" placeholder="Search for a movie..." id="movie-search-box" name="searchContent">
        <div class="button-container">
            <button type="submit" class="search-button" >Search</button>
            <button type="reset" class="clear-button" name="clearButton" >Clear</button>
        </div>
        </form>
    </div>
</div>

<%--End of search container--%>

<%--Rsulult container--%>
<jsp:include page="search-result.jsp"/>
<%--End of Result container--%>




</body>
</html>