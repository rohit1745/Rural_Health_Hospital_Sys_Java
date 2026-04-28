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
 * Servlet implementation class p_3_PatientChangePassword
 */
public class p_3_PatientChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_3_PatientChangePassword() {
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
		String PatientEmailID = request.getParameter("PatientEmailID");
		System.out.println("Patien Email ID="+PatientEmailID);
		
		
		String PatientOldPassword=request.getParameter("PatientOldPassword");
		System.out.println("Patientl Old Password="+PatientOldPassword);
		
		String PatientNewPassword=request.getParameter("PatientNewPassword");
		System.out.println("Patient New Password="+PatientNewPassword);
		
		String PatientConformPassword=request.getParameter("PatientConformPassword");
		System.out.println("Patient Conform Password="+PatientConformPassword);
		
		
		System.out.println("hello");
		Connection con=ConnectionDB.connect();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from patient where PEmail=? and PPassword=?");
			pstmt.setString(1, PatientEmailID);
			pstmt.setString(2, PatientOldPassword);
			ResultSet rs=pstmt.executeQuery();
			
			 if (rs.next()) {
	               
	                PreparedStatement ps2 = con.prepareStatement("UPDATE patient SET PPassword=? WHERE PEmail=?"
	                );
	                ps2.setString(1, PatientNewPassword);
	                System.out.println("patient password");
	                ps2.setString(2, PatientEmailID);
	                System.out.println("Patient email Id");

	                ps2.executeUpdate();
	                response.sendRedirect("p_3_PatientProfile.html");
	                System.out.println("password successfully change....");
	            } else {
	                response.sendRedirect("p_3_PatientProfile.html");
	                System.out.println("Old Password is not match....");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("ChangePassword.jsp?msg=Something+went+wrong");
	        }

		doGet(request, response);
	}

}
