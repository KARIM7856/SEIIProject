package SEIIProject.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private SWIIAuthenticationProvider authProvider;
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//httpSecurity.formLogin().loginPage("/login").usernameParameter("userName").passwordParameter("password").permitAll();
		httpSecurity.authorizeRequests().antMatchers("/printAll").hasAuthority("ROLE_administrator").and();
		 
	}
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
	    auth.authenticationProvider(authProvider);
	}

}
