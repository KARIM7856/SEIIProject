package SEIIProject.Repository;

import java.sql.*;

public class DataRepository {
	
	public Connection con;
	public Statement st;
	public ResultSet rs;
	
	
	public DataRepository()
	{
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swii", "root", "");
			st = con.createStatement();
			
			
		}catch(Exception e) 
		{
			System.out.println("error3 : " + e);
		}
	}
	
}
