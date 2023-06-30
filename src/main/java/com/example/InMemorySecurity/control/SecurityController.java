package com.example.InMemorySecurity.control;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @GetMapping("/forall")
    public String greet()
    {
        return "working";

    }

    @GetMapping("/admin")
    public String greetAdmin()
    {
        return "Adminworking";

    }

    @GetMapping("/user")
    public String greetuser()
    {
        return "Userworking";
    }
}
