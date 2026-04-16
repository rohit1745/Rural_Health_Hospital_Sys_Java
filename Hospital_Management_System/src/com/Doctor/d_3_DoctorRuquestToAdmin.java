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
 * Servlet implementation class d_3_DoctorRuquestToAdmin
 */
public class d_3_DoctorRuquestToAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d_3_DoctorRuquestToAdmin() {
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
		
		System.out.println("Hii");
		int DID=0;
		
		String DoctorName = request.getParameter("DoctorName");
		System.out.println("Doctor Name="+DoctorName);
		
		String DoctorGender = request.getParameter("DoctorGender");
		System.out.println("Doctor Gender="+DoctorGender);
		
		String DoctorSpecialization = request.getParameter("DoctorSpecialization");
		System.out.println("Doctor Specialization="+DoctorSpecialization);
		
		String DoctorContact = request.getParameter("DoctorContact");
		System.out.println("Doctor Contact="+DoctorContact);
		
		String DoctorEmail = request.getParameter("DoctorEmail");
		System.out.println("Doctor Email="+DoctorEmail);
		
		String DoctorPassword = request.getParameter("DoctorPassword");
		System.out.println("Doctor Password="+DoctorPassword);
		

		Connection con=ConnectionDB.connect();
		System.out.println("connnect");
		
		try
		{
			PreparedStatement ps = con.prepareStatement("INSERT INTO doctor_request (DID, DName, DGender, DSpecialization, DContact, DEmail, DPassword, Status) VALUES (?,?,?,?,?,?,?,?)");
			ps.setInt(1, DID);
			ps.setString(2, DoctorName);
			ps.setString(3, DoctorGender);
			ps.setString(4, DoctorSpecialization);
			ps.setString(5, DoctorContact);
			ps.setString(6, DoctorEmail);
			ps.setString(7, DoctorPassword);
			ps.setString(8, "PENDING");
			System.out.println("data updated..........");
			
			ps.executeUpdate();

			response.sendRedirect("index.html?msg=Request+sent+to+Admin");
			System.out.println("updated");
		}
		catch(Exception e){
			e.printStackTrace();
			response.sendRedirect("index.html?msg=Error");
		
		}
		
		
		
		doGet(request, response);
	}

}
