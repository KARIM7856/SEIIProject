package SEIIProject.Model;

import SEIIProject.Repository.DataRepository;

public abstract class AbstractUser {
	
	String firstName;
	String lastName;
	String userName;
	String password;
	String email;
	String type;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	
	public AbstractUser(String firstName, String lastName,String userName, String password, String email, String type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	public AbstractUser() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		String result = "Welcome" +' ' + firstName + ' ' + lastName + '!';
		return result;
	}

	public void saveToDatabase() {
		DataRepository dr = new DataRepository();
		String query = "INSERT INTO users (firstName, lastName, userName, password, email, type) VALUES"
				+ "('" + getFirstName() + "','" + getLastName() + "','" + getUserName() + "','" + getPassword() + "','" + getEmail() + "','" 
				+ getType()+ "')";
		try
		{
			int row = dr.st.executeUpdate(query);
		}catch(Exception e){
			System.out.println("error2 : " + e);
		}
	}
}
