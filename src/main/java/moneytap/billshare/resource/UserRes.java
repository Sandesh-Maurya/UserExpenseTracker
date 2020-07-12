package moneytap.billshare.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/rest/new")
@RestController
public class  UserRes {
    @GetMapping("/hello")
    public String hello_public(){
        return "Hello peeps";

    }
    @GetMapping("/secured/hello")
    public String secured_hello(){
        return "HELLO FROM SECURED ORIGIN";
    }

}
