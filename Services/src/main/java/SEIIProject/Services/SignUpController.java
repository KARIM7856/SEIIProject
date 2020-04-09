package SEIIProject.Services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SEIIProject.Model.*;
import SEIIProject.Repository.DataRepository;
import SEIIProject.Repository.Loader;
import SEIIProject.Repository.UserLoader;

@RestController
public class SignUpController {
	
	@RequestMapping("/signup")
	String signUp(HttpServletRequest rep) {
		
		AbstractUser user;
		String firstName = rep.getParameter("firstName");
		String lastName = rep.getParameter("lastName");
		String userName = rep.getParameter("userName");
		String password = rep.getParameter("password");
		String email = rep.getParameter("email");
		String type = rep.getParameter("type");
		
		
		
		user = UserFactory.getUser(type);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmail(email);
		user.setType(type);
		user.saveToDatabase();
		
		return user.toString();
		
		
	}
	
		
		@RequestMapping("/printAll")
		public ArrayList<AbstractUser> printAll() {
			Loader l = new UserLoader();
			//ArrayList<AbstractUser> au = new ArrayList();
			//AbstractUser u = null;
			return l.loadALL();
		}

}
