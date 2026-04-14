package com.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionDB;

/**
 * Servlet implementation class p_4_patientBookAppointment
 */
public class p_4_patientBookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_4_patientBookAppointment() {
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
		int AID=0;
		String DoctorName=request.getParameter("DoctorName");
		System.out.println("Doctor Name="+DoctorName);
		
		String PatientName=request.getParameter("PatientName");
		System.out.println("Patient Name="+PatientName);
		
		String Date=request.getParameter("Date");
		System.out.println("Date="+Date);
		
		String Time=request.getParameter("Time");
		System.out.println("Time="+Time);
		
		String Status=request.getParameter("Status");
		System.out.println("Status="+Status);
		
		
		System.out.println("hello");
		
		Connection con=ConnectionDB.connect();
		
		try {
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO appiontment(AID, ADoctor, APatient, ADate, ATime, AStatus) VALUES (?,?,?,?,?,?)");
			pstmt.setInt(1, AID);
			pstmt.setString(2, DoctorName);
			pstmt.setString(3, PatientName);
			pstmt.setString(4, Date);
			pstmt.setString(5, Time);
			pstmt.setString(6, Status);
			
			
			 pstmt.executeUpdate();

	            response.sendRedirect("p_3_PatientProfile.html");
	            System.out.println("data updated......");

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("error.jsp");
	            System.out.println("Error....");
	        }
		
		
	}

}
