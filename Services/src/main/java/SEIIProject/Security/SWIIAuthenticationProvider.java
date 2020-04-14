package SEIIProject.Security;

import java.util.ArrayList;
import java.util.List;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;

import SEIIProject.Model.AbstractUser;

@Component
public class SWIIAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String usernameOrEmail = authentication.getName();
		String password = authentication.getCredentials().toString();
		Authentication result = null;
		if(AbstractUser.checkUserDetails(usernameOrEmail, password)) {
			List<String> roleList = new ArrayList<String>();
			roleList.add("ADMIN");
			result = new UsernamePasswordAuthenticationToken(usernameOrEmail, password, getGrantedAuthorities(roleList));
		}
		return result;
	}
	
	public List<GrantedAuthority> getGrantedAuthorities(List<String> roleList){
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		for(String role : roleList) {
			result.add(new SimpleGrantedAuthority("ROLE_" + role));
		}
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
