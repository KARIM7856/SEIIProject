package SEIIProject.Model;

public class Administrator extends AbstractUser {

	public Administrator(String firstName, String lastName,String userName, String password, String email, String type) {
		super(firstName, lastName,userName, password, email, type);
		
	}

	public Administrator() {
		super();
	}


	/*public void saveToDatabase() {
		// TODO Auto-generated method stub
		
	}*/

}
