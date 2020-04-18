package SEIIProject.Repository;

import java.sql.*;



public class DataRepository {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	
	public DataRepository()
	{
		try {
			

			con = DriverManager.getConnection("jdbc:mysql://localhost:8886/swii", "users", "users");

			st = con.createStatement();
			
			
		}catch(Exception e) 
		{
			System.out.println("error3 : " + e);
		}
	}
	
}
