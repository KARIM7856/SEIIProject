package SEIIProject.Model;

public class StoreOwner extends AbstractUser {

	public StoreOwner(String firstName, String lastName,String userName, String password, String email, String type) {
		super(firstName, lastName,userName, password, email, type);
		
	}

	public StoreOwner() {
		super();
	}
	
	


	/*public void saveToDatabase() {
		// TODO Auto-generated method stub
		
	}*/

}
