package com.AdminLogin;

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
 * Servlet implementation class h_1_AdminLogin
 */
public class h_1_AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public h_1_AdminLogin() {
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
		String AdminEmail=request.getParameter("AdminEmail");
		System.out.println("email="+AdminEmail);
		String AdminPassword=request.getParameter("AdminPassword");
		System.out.println("password="+AdminPassword);
		
		System.out.println("hello");
		Connection con=ConnectionDB.connect();
		try {
			PreparedStatement pstmt=con.prepareStatement("select * from admin where email=? and password=?");
			pstmt.setString(1, AdminEmail);
			pstmt.setString(2, AdminPassword);
			ResultSet rs=pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				System.out.println("sucessful");
				i=1;
				
			}
			if(i>0)
			{
				response.sendRedirect("a_2_AdminProfile.html");
			}
			else
			{
				response.sendRedirect("r_1_Dashboard.html");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
