package SEIIProject.Services;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SEIIProject.Model.AbstractUser;
import SEIIProject.Model.UserFactory;
import SEIIProject.Repository.Loader;
import SEIIProject.Repository.UserLoader;
import SEIIProject.Security.SWIIAuthenticationProvider;


@RestController
public class UserControllerProxy implements UserControllerIterface{
	
	UserController uc = new UserController();
	
	@RequestMapping(path = "/signup", method = RequestMethod.POST)
	public String signUp(HttpServletRequest rep) {
		
		
		return uc.signUp(rep);
		
		
	}
		@RequestMapping("/printAll")
		public ArrayList<AbstractUser> printAll() {
			
			return uc.printAll();
		}
		
		
		@RequestMapping(path = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
			
			AuthenticationProvider authP = new SWIIAuthenticationProvider();
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userID, password);
			
			String responseMessage;
			Responder response;
			auth = authP.authenticate(token);
			
			if(auth == null) {
				responseMessage = "wrong user name or password";
				response = new Responder(responseMessage);
				return response;
			}
			
			else {
				return uc.login(rep, auth);
			}
			
		}	
}
