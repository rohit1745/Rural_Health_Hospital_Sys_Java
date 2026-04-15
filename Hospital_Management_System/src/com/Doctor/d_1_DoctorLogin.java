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
 * Servlet implementation class d_1_DoctorLogin
 */
public class d_1_DoctorLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d_1_DoctorLogin() {
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
			String DoctorEmail=request.getParameter("DoctorEmail");
			System.out.println("Doctor Email="+DoctorEmail);
			String DoctorPassword=request.getParameter("DoctorPassword");
			System.out.println("Doctor Password="+DoctorPassword);
			
			System.out.println("hello");
			Connection con=ConnectionDB.connect();
			try {
				PreparedStatement pstmt=con.prepareStatement("select * from doctor where DEmail=? and DPassword=?");
				pstmt.setString(1, DoctorEmail);
				pstmt.setString(2, DoctorPassword);
				ResultSet rs=pstmt.executeQuery();
				int i=0;
				while(rs.next())
				{
					System.out.println("sucessful");
					i=1;
					
				}
				if(i>0)
				{
					response.sendRedirect("d_2_DoctorProfile.html");
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
