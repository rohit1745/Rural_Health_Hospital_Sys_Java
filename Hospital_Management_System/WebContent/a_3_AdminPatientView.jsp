<%@page import="java.sql.ResultSet"%>
<%@page import="com.connection.ConnectionDB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<center>
<h2 align="center">Patients</h2>
<table border="1" cellpadding="8">
<tr>
<%
Connection con=ConnectionDB.connect();
try{
	PreparedStatement pstmt = con.prepareStatement("SELECT* FROM patient");
	ResultSet rs = pstmt.executeQuery();
%>	
	<th>PID</th>
	<th>PName</th>
	<th>PAge</th>
	<th>PGender</th>
	<th>PContact</th>
	<th>PAddress</th>
	<th>PEmail</th>
	<th>PPassword</th>
	<% while(rs.next()){ %>
	
</tr>
	<tr>
		
			<td><%= rs.getInt("PID") %></td>
            <td><%= rs.getString("PName") %></td>
            <td><%= rs.getInt("PAge") %></td>
            <td><%= rs.getString("PGender") %></td>
            <td><%= rs.getString("PContact") %></td>
            <td><%= rs.getString("PAddress") %></td>
            <td><%= rs.getString("PEmail") %></td>
            <td><%= rs.getString("PPassword") %></td>
	</tr>
	<% }
}
catch(Exception e)
{
	e.printStackTrace();

	
}

%>
</table>		
</center>
</body>
</html>