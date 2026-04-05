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
<h2 align="center">Appointments</h2>
<table border="1" cellpadding="6">
<tr>
<%
Connection con=ConnectionDB.connect();
try{
	PreparedStatement pstmt = con.prepareStatement("SELECT * FROM appiontment");
	ResultSet rs = pstmt.executeQuery();
%>	
	<th>AID </th>
	<th>ADoctor</th>
	<th>APatient</th>
	<th>ADate</th>
	<th>ATime</th>
	<th>AStatus</th>
	
	<% while(rs.next()){ %>
	
</tr>
	<tr>
		
			<td><%= rs.getInt("AID") %></td>
            <td><%= rs.getString("ADoctor") %></td>
            <td><%= rs.getString("APatient") %></td>
            <td><%= rs.getString("ADate") %></td>
            <td><%= rs.getString("ATime") %></td>
            <td><%= rs.getString("AStatus") %></td>
            
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