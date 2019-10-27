package assignment1.config;

import assignment1.entities.UserRole;
import assignment1.util.EndpointsUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
                .antMatchers(HttpMethod.GET, EndpointsUtil.PATIENT + "/**").hasAnyRole(UserRole.ROLE_PATIENT.withoutRoleKey(), UserRole.ROLE_DOCTOR.withoutRoleKey())
                .antMatchers(HttpMethod.GET, EndpointsUtil.CAREGIVER + EndpointsUtil.CAREGIVER_PATIENTS).hasRole(UserRole.ROLE_CAREGIVER.withoutRoleKey())
                .antMatchers(EndpointsUtil.CAREGIVER).hasRole(UserRole.ROLE_DOCTOR.withoutRoleKey())
                .antMatchers("/oauth/**").permitAll()
                .antMatchers(EndpointsUtil.USER + "/**").permitAll()
                .antMatchers("/stomp").permitAll()
                .antMatchers("/**").hasRole(UserRole.ROLE_DOCTOR.withoutRoleKey())
                .and().csrf().disable();
    }
}
