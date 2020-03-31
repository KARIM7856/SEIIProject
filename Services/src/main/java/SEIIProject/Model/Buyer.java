package SEIIProject.Model;

public class Buyer extends AbstractUser {

	public Buyer(String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		
	}

	public Buyer() {
		super();
	}

	@Override
	public void saveToDatabase() {
		System.out.println("dfsdfsdf");
	}

}
