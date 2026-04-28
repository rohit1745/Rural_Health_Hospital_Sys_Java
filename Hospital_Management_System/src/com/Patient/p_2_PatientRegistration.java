package com.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionDB;

/**
 * Servlet implementation class p_2_PatientRegistration
 */
public class p_2_PatientRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_2_PatientRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hii");
		doGet(request, response);
		int PID=0;
		String PatientName=request.getParameter("PatientName");
		System.out.println("PatientName="+PatientName);
		
		int PatientAge=Integer.parseInt(request.getParameter("PatientAge"));
		System.out.println("PatientAge="+PatientAge);
		
		String PatientGender=request.getParameter("PatientGender");
		System.out.println("PatientGender="+PatientGender);
		
		String PatientMobilNo=request.getParameter("PatientMobilNo");
		System.out.println("PatientMobilNo="+PatientMobilNo);
		
		String PatientAddress=request.getParameter("PatientAddress");
		System.out.println("PatientAddress="+PatientAddress);
		
		String PatientEmail=request.getParameter("PatientEmail");
		System.out.println("PatientEmail="+PatientEmail);
		
		String PatientPassword=request.getParameter("PatientPassword");
		System.out.println("PatientPassword="+PatientPassword);
		
		System.out.println("hello");
		
		Connection con=ConnectionDB.connect();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO patient(PID, PName, PAge, PGender, PContact, PAddress, PEmail, PPassword) VALUES (?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, PID);
			pstmt.setString(2, PatientName);
			pstmt.setInt(3, PatientAge);
			pstmt.setString(4, PatientGender);
			pstmt.setString(5, PatientMobilNo);
			pstmt.setString(6, PatientAddress);
			pstmt.setString(7, PatientEmail);
			pstmt.setString(8, PatientPassword);
			
			 pstmt.executeUpdate();

	            response.sendRedirect("index.html");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	        }
		
	}

}
