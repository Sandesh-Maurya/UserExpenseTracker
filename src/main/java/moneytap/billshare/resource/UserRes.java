package moneytap.billshare.resource;

import moneytap.billshare.Service.userService;
import moneytap.billshare.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Changes needed
 * Integrate UserRes to ExpenseController
 */

@RequestMapping("/Home")
@RestController
public class  UserRes {
    private userService userService;
    @GetMapping("/login")
    public String hello_public(){
        return "login";

    }
    @GetMapping("/User/expenseTracker") //login required ----test url
    public String secured_hello(){
        return "HELLO FROM SECURED ORIGIN";
    }

    @GetMapping("/UserRegistration")
    String signUp() {

        return "UserRegistration";
    }
    @PostMapping("/UserRegistration")
    String signUp(Users user) {
        userService.signUpUser(user);

        return "redirect:/login";
    }

}
