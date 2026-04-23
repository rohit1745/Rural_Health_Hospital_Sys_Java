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
 * Servlet implementation class p_1_PatientLogin
 */
public class p_1_PatientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public p_1_PatientLogin() {
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
		String PatientEmail=request.getParameter("PatientEmail");
		System.out.println("PatientEmail="+PatientEmail);
		String PatientPassword=request.getParameter("PatientPassword");
		System.out.println("PatientPassword="+PatientPassword);
		
		System.out.println("hello");
		Connection con=ConnectionDB.connect();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from patient where PEmail=? and PPassword=?");
			pstmt.setString(1, PatientEmail);
			pstmt.setString(2, PatientPassword);
			ResultSet rs=pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				System.out.println("sucessful");
				i=1;
				
			}
			if(i>0)
			{
				response.sendRedirect("p_3_PatientProfile.html");
			}
			else
			{
				response.sendRedirect("index.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
