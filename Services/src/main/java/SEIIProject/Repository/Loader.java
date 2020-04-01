package SEIIProject.Repository;

import java.util.ArrayList;

import SEIIProject.Model.AbstractUser;

public interface Loader {
	public default  ArrayList<AbstractUser> loadALL()
	{
		return null;
	}
}
