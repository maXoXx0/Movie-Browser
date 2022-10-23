<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import="java.io.*"
    %>

<%--Result container--%>
    <table align="center">
        <%
            List movielist = new ArrayList();
            movielist = (ArrayList)request.getAttribute("movielist");
            if(movielist != null && movielist.size() > 0) {
        %>
        <h2 align="center">Result</h2>
        <tr>
            <th>Poster</th>
            <th>Movie title</th>
            <th>Release date</th>
            <th>Description</th>
        </tr>
        <%
        for(int i=0;i<movielist.size();i++){
        List movie=(List)movielist.get(i);
        %>
            <tr>
                <td><%=movie.get(1) %></td>
                <td><%=movie.get(2) %></td>
                <td><%=movie.get(3) %></td>
                <td><%=movie.get(4) %></td>
            </tr>
        <%
        }else{
        %>
            <tr>
                <td> No records found </td>
            </tr>
        <%}%>
    </table>
</div>
<%--End of Result container--%>