package com.iscae.Election.controllers.users;

import com.iscae.Election.Model.User;
import com.iscae.Election.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/all")
    public List<User> allAccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetailsImpl user = (UserDetailsImpl)authentication.getPrincipal();
        return userRepository.findAll();
    }


    @GetMapping("/user")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    public String moderatorAccess() {
        return "VENDEUR Board.";
    }

    @GetMapping("/admin")
    public String adminAccess() {
        return "Admin Board.";
    }
}