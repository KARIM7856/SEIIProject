package SEIIProject.Model;

public class StoreOwner extends AbstractUser {

	public StoreOwner(String firstName, String lastName, String password, String email) {
		super(firstName, lastName, password, email);
		
	}

	public StoreOwner() {
		super();
	}
	
	

	@Override
	public void saveToDatabase() {
		// TODO Auto-generated method stub
		
	}

}
