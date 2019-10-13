package assignment1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void init(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(getAuthenticationProvider());
	}

	private DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(customUserDetailService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		return daoAuthenticationProvider;
	}

	@Bean
	public NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
