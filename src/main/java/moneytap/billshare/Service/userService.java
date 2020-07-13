package moneytap.billshare.Service;

import jdk.internal.dynalink.support.NameCodec;
import moneytap.billshare.UserRepository.UserRepository;
import moneytap.billshare.model.GetUserDetails;
import moneytap.billshare.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService implements UserDetailsService {
    @Autowired
    private UserRepository UserRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user_exist = UserRepository.findByName(username);

        user_exist
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return user_exist
                .map(GetUserDetails::new).get();
    }

    /** Little work here
     * For the registration process
     * @param user
     */
    public void signUpUser(Users user) {

        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        final Users createdUser = UserRepository.save(user);

    }
}
