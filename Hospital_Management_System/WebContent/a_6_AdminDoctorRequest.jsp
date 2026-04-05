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
<h2 align="center">Doctor Request</h2>
<table border="1" cellpadding="8">
<tr>
<%
Connection con=ConnectionDB.connect();
try{
	PreparedStatement pstmt = con.prepareStatement("SELECT* FROM doctor_request");
	ResultSet rs = pstmt.executeQuery();
%>	
	<th>DID</th>
	<th>DName</th>
	
	<th>DGender</th>
	<th>DSpecialization</th>
	<th>DContact</th>

	<th>DEmail</th>
	<th>DPassword</th>
	<th>Status</th>
	<% while(rs.next()){ %>
	
	<tr>
		
			<td><%= rs.getInt("DID") %></td>
            <td><%= rs.getString("DName") %></td>
           
            <td><%= rs.getString("DGender") %></td>
            
            <td><%= rs.getString("DSpecialization") %></td>
        	 <td><%= rs.getString("DPassword") %></td>
            <td><%= rs.getString("DEmail") %></td>
            <td><%= rs.getString("DPassword") %></td>
             <td><%= rs.getString("Status") %></td>
             
             <td>
        <form action="d_4_AdminDoctorApproval" method="post" style="display:inline;">
            <input type="hidden" name="DID" value="<%= rs.getInt("DID") %>">
            <input type="hidden" name="Status" value="approve">
            <button type="submit">Approve</button>
        </form>

        <form action="d_4_AdminDoctorApproval" method="post" style="display:inline;">
            <input type="hidden" name="DID" value="<%= rs.getInt("DID") %>">
            <input type="hidden" name="Status" value="reject">
            <button type="submit" style="background:red;color:white;">Reject</button>
        </form>
    </td>
             
	</tr>
	<% }
}
catch(Exception e)
{
	e.printStackTrace();

	
}

%>
</body>
</html>