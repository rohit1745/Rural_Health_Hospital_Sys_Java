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
	PreparedStatement pstmt = con.prepareStatement("SELECT* FROM doctor");
	ResultSet rs = pstmt.executeQuery();
%>	
	<th>DID</th>
	<th>DName</th>
	<th>DGender</th>
	<th>DSpecialization</th>
	<th>DContact</th>
	
	<th>DEmail</th>
	<th>DPassword</th>
	<% while(rs.next()){ %>
	
</tr>
	<tr>
		<!-- <td>rs.next(1)</td>
		<td>rs.next(2)</td>
		<td>rs.next(3)</td>
		<td>rs.next(4)</td>
		<td>rs.next(5)</td>
		<td>rs.next(6)</td>
		<td>rs.next(7)</td>
		<td>rs.next(8)</td> -->
			<td><%= rs.getInt("DID") %></td>
            <td><%= rs.getString("DName") %></td>
          	 
            <td><%= rs.getString("DGender") %></td>
            <td><%= rs.getString("DSpecialization") %></td>
            <td><%= rs.getString("DContact") %></td>
           
            <td><%= rs.getString("DEmail") %></td>
            <td><%= rs.getString("DPassword") %></td>
	</tr>
	<% }
	rs.close();
    pstmt.close();
    con.close();
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