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
 * Servlet implementation class d_4_AdminDoctorApproval
 */
public class d_4_AdminDoctorApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public d_4_AdminDoctorApproval() {
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
		
		int DID = Integer.parseInt(request.getParameter("DID"));
        String Status = request.getParameter("Status");
        System.out.println("data request");
        
        Connection con=ConnectionDB.connect();
		System.out.println("connnect");
		
		
		
		
		try {
           

            if(Status.equals("approve")) {

                // 1️⃣ Get doctor from request table
            	PreparedStatement ps = con.prepareStatement("SELECT * FROM doctor_request WHERE DID=?");
                ps.setInt(1, DID);
                
                System.out.println("Data Approve");
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {

                    // 2️⃣ Insert into doctor table
                	PreparedStatement ps2 = con.prepareStatement("INSERT INTO doctor( DName, DGender, DSpecialization, DContact, DEmail, DPassword) VALUES (?,?,?,?,?,?)");
                   
                    ps2.setString(1, rs.getString("DName"));
                    ps2.setString(2, rs.getString("DGender"));
                    ps2.setString(3, rs.getString("DSpecialization"));
                    ps2.setString(4, rs.getString("DContact"));
                    ps2.setString(5, rs.getString("DEmail"));
                    ps2.setString(6, rs.getString("DPassword"));
                    ps2.executeUpdate();

                    // 3️⃣ Delete from request table
                    PreparedStatement ps3 = con.prepareStatement("DELETE FROM doctor_request WHERE DID=?");
                    ps3.setInt(1, DID);
                    
                    System.out.println("Delete data from doctor table");
                    ps3.executeUpdate();
                }

            } else if(Status.equals("reject")) {

            	PreparedStatement ps = con.prepareStatement("DELETE FROM doctor_request WHERE DID=?");
                ps.setInt(1, DID);
                
                System.out.println("Reject");
                ps.executeUpdate();
            }

            response.sendRedirect("a_6_AdminDoctorRequest.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		
		
		doGet(request, response);
	}

}
