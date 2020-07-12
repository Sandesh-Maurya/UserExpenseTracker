package moneytap.billshare.UserRepository;

import moneytap.billshare.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
    //optional because what if user does not exits
}
