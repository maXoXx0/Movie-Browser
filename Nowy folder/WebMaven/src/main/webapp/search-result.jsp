<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         import="java.util.*"
%>

<%--Result container--%>
<form method="get">
<table align="center" >
    <%
        List movielist;
        movielist = (ArrayList)request.getAttribute("movielist");
        if(movielist != null && movielist.size() > 0) {
    %>
    <h2 align="center">Result</h2>
    <tr>
        <th>Poster</th>
        <th>Movie title</th>
        <th width="100">Release date</th>
        <th>Description</th>
    </tr>
    <%
        for(int i=0;i<movielist.size();i++){
            List movie=(List)movielist.get(i);
    %>
    <tr>
        <td><img src=<%=movie.get(0)%> width="94" height="141"></td>
        <td><%=movie.get(1) %></td>
        <td><%=movie.get(2) %></td>
        <td><%=movie.get(3) %></td>
    </tr>
    <%
        }
        }else{
    %>
    <tr>
        <td> No records found </td>
    </tr>
    <%;}%>
</table>
</form>
</div>
<%--End of Result container--%>