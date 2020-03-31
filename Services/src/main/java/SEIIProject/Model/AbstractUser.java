package SEIIProject.Model;

public abstract class AbstractUser {
	
	String firstName;
	String lastName;
	String password;
	String email;
	
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

	
	public AbstractUser(String firstName, String lastName, String password, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}

	public AbstractUser() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		String result = "Welcome " +' ' + firstName + ' ' + lastName + '!';
		return result;
	}

	public abstract void saveToDatabase();
}
