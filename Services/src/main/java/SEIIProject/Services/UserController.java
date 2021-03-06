package SEIIProject.Services;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import SEIIProject.Model.*;
import SEIIProject.Repository.DataRepository;
import SEIIProject.Repository.Loader;
import SEIIProject.Repository.UserLoader;
import SEIIProject.Security.*;

@RestController
public class UserController implements UserControllerIterface {
	
	public String signUp(HttpServletRequest rep) {
		
		AbstractUser user;
		
		String firstName = "" + rep.getParameter("firstName");
		String lastName = "" + rep.getParameter("lastName");
		String userName = "" + rep.getParameter("userName");
		String password = "" + rep.getParameter("password");
		String email = "" + rep.getParameter("email");
		String type = "" + rep.getParameter("type");
		
		
		
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
		public ArrayList<AbstractUser> printAll() {
			Loader l = new UserLoader();
			return l.loadALL();
		}
		
		
		public Responder login(HttpServletRequest rep, Authentication auth) {
			String userName = rep.getParameter("userName");
			String password = rep.getParameter("password");
			String email = rep.getParameter("email");
			String userID = "";
			if(password == null) {
				userID = email;
			}
			else {
				userID = userName;
			}
			
			SecurityContext securityContext = SecurityContextHolder.getContext();
		    securityContext.setAuthentication(auth);
		    HttpSession session = rep.getSession(true);
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

			
			return new Responder("success");
		}

}