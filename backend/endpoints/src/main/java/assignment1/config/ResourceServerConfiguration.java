package assignment1.config;

import assignment1.entities.UserRole;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableResourceServer
@EnableWebMvc
@EnableOAuth2Client
@EnableWebSecurity
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().and()
                .authorizeRequests()
                .antMatchers("/test").hasRole(UserRole.ROLE_DOCTOR.toString().substring(5))
                .antMatchers("/**").permitAll()
                .and().csrf().disable();
    }
}
