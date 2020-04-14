package SEIIProject.Model;

public class UserFactory {
	public static AbstractUser getUser(String userType) {
		switch(userType) {
		case "buyer":
			return new Buyer();
		case "storeowner":
			return new StoreOwner();
		case "admin":
			return new Administrator();
			default:
				System.err.println("No such type");
				System.exit(1);
				return null;
		}
	}
}
