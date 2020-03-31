package SEIIProject.Model;

public class Administrator extends AbstractUser {

	public Administrator(String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		
	}

	public Administrator() {
		super();
	}

	@Override
	public void saveToDatabase() {
		// TODO Auto-generated method stub
		
	}

}
