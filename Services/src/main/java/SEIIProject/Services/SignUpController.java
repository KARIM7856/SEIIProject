package SEIIProject.Services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SEIIProject.Model.*;

@RestController
public class SignUpController {
	
	@RequestMapping("/signup")
	String signUp(HttpServletRequest rep) {
		
		AbstractUser user;
		String email = rep.getParameter("email");
		String firstName = rep.getParameter("firstName");
		String lastName = rep.getParameter("lastName");
		String password = rep.getParameter("password");
		String type = rep.getParameter("Type");
		
		
		
		user = UserFactory.getUser(type);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		
		user.saveToDatabase();
		
		return user.toString();
		
		
	}
	
	

}
