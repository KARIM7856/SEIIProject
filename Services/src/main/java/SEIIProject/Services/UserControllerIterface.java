package SEIIProject.Services;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

import SEIIProject.Model.AbstractUser;

public interface UserControllerIterface {
	public default String signUp(HttpServletRequest rep) {
		return null;
	}
	
	public default ArrayList<AbstractUser> printAll(){
		return null;
	}
	
	public default Responder login(HttpServletRequest rep, Authentication auth) {
		return null;
	}
	
}
