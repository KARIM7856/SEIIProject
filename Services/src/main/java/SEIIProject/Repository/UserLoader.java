package SEIIProject.Repository;

import java.util.ArrayList;

import SEIIProject.Model.AbstractUser;
import SEIIProject.Model.Administrator;
import SEIIProject.Model.Buyer;
import SEIIProject.Model.StoreOwner;
import SEIIProject.Model.UserFactory;

public class UserLoader implements Loader{
	public ArrayList<AbstractUser> loadALL()
	{
		String query;
		DataRepository dr = new DataRepository(); 
		ArrayList<AbstractUser> au = new ArrayList();
		try 
		{
			
			query = "SELECT * FROM Users";
			dr.rs = dr.st.executeQuery(query);
			//System.out.println("records from the database : ");
			
			while(dr.rs.next())
			{
				String fName = dr.rs.getString("firstName");
				String lName = dr.rs.getString("lastName");
				String uName = dr.rs.getString("userName");
				String pass = dr.rs.getString("password");
				String email = dr.rs.getString("email");
				String type = dr.rs.getString("type");
				AbstractUser u = null;
				u = UserFactory.getUser(type);
				u.setFirstName(fName);
				u.setLastName(lName);
				u.setUserName(uName);
				u.setPassword(pass);
				u.setEmail(email);
				u.setType(type);
				au.add(u);
			}
			
		}catch(Exception e)
		{
			System.out.println("error1 : " + e);
		}
		return au;
	}

}
