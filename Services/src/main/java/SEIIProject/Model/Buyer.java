package SEIIProject.Model;

public class Buyer extends AbstractUser {

	public Buyer(String firstName, String lastName,String userName, String password, String email, String type) {
		super(firstName, lastName,userName, password, email, type);
		
	}

	public Buyer() {
		super();
	}

	/*public void saveToDatabase() {
		System.out.println("dfsdfsdf");
	}*/

}
