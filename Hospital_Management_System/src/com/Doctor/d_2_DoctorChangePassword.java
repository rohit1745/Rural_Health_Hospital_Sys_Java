package com.Doctor;

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
 * Servlet implementation class d_2_DoctorChangePassword
 */
public class d_2_DoctorChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d_2_DoctorChangePassword() {
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
		String DoctorEmailID = request.getParameter("DoctorEmailID");
		System.out.println("Doctor Email ID="+DoctorEmailID);
		
		
		String DoctorOldPassword=request.getParameter("DoctorOldPassword");
		System.out.println("Doctor Old Password="+DoctorOldPassword);
		
		String DoctorNewPassword=request.getParameter("DoctorNewPassword");
		System.out.println("Doctor New Password="+DoctorNewPassword);
		
		String DoctorConfirmPassword=request.getParameter("DoctorConfirmPassword");
		System.out.println("Doctor Confirm Password="+DoctorConfirmPassword);
		
		
		System.out.println("hello");
		Connection con=ConnectionDB.connect();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from doctor where DEmail=? and DPassword=?");
			pstmt.setString(1, DoctorEmailID);
			pstmt.setString(2, DoctorOldPassword);
			ResultSet rs=pstmt.executeQuery();
			
			 if (rs.next()) {
	               
	                PreparedStatement ps2 = con.prepareStatement("UPDATE doctor SET DPassword=? WHERE DEmail=?"
	                );
	                ps2.setString(1, DoctorNewPassword);
	                System.out.println("Doctor password");
	                ps2.setString(2, DoctorEmailID);
	                System.out.println("Doctor Email ID");

	                ps2.executeUpdate();
	                response.sendRedirect("d_2_DoctorProfile.html");
	                System.out.println("password successfully change....");
	            } else {
	                response.sendRedirect("d_2_DoctorProfile.html");
	                System.out.println("Old Password is not match....");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            response.sendRedirect("ChangePassword.jsp?msg=Something+went+wrong");
	        }
		doGet(request, response);
	}

}
