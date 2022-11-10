package ec.edu.ups.projectgames.security;



import ec.edu.ups.projectgames.entitty.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final String URI_USERS = "http://localhost:8080/securities/";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = restTemplate.getForObject(URI_USERS + SecurityConstants.GET_USER + username, User.class);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
