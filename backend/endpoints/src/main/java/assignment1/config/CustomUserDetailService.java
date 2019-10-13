package assignment1.config;


import assignment1.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Configurable
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        assignment1.entities.User user = userService.getUserAfterUsername(username);
//        System.out.println(user.getUsername());
        if(user == null){
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }


}
