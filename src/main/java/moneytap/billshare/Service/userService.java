package moneytap.billshare.Service;

import moneytap.billshare.UserRepository.UserRepository;
import moneytap.billshare.model.GetUserDetails;
import moneytap.billshare.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService implements UserDetailsService {
    @Autowired
    private UserRepository UserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user_exist = UserRepository.findByName(username);

        user_exist
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user_exist
                .map(GetUserDetails::new).get();
    }

}
