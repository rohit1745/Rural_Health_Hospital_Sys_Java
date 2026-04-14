package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB
{
	static Connection con=null;
	public static Connection connect()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HospitalDB","root","");
			if(con==null)
			
			{
				System.out.println("Failed to connect......");
			}
				else
				{
					System.out.println("Connect......");
				}
			}
			catch(Exception e)
			{
				System.out.println("Faild to connection...!!");
				e.printStackTrace();
			}
		return (con);
	}
	
}
