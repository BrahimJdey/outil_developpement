package com.iscae.springProject.controllers.users;

import com.iscae.springProject.Dtos.EtudientDto;
import com.iscae.springProject.Dtos.UserDto;
import com.iscae.springProject.models.Etudient;
import com.iscae.springProject.models.User;
import com.iscae.springProject.repositories.EtudientRepo;
import com.iscae.springProject.repositories.UserRepository;
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




    @Autowired
    EtudientRepo etudientRepo;
//    @PostMapping("/add")
//    public void add(@RequestBody EtudientDto etudientDto) {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Etudient etudient = new Etudient();
//        etudient.setIne(etudientDto.getIne());
//        etudient.setNom(etudientDto.getNom());
//        etudient.setPrenom(etudientDto.getPrenom());
//        etudient.setDate(etudientDto.getDate());
//        etudient.setEmail(etudientDto.getEmail());
//        etudient.setPassword(encoder.encode(etudientDto.getPassword()));
//        etudient.setInscription(etudientDto.getInscription());
//        etudient.setNiveau(etudientDto.getNiveau());
//        etudient.setEtablisement(etudientDto.getEtablisement());
//
//
//
//        etudientRepo.save(etudient);
//    }
//
//
//    @PutMapping("/{id}")
//    public void update(@RequestBody UserDto userDto, @PathVariable("id") Long id) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = userRepository.findById(id).orElseThrow();
//        user.setNom(userDto.getNom());
//        user.setPrenom(userDto.getPrenom());
//        user.setTelephone(userDto.getTelephone());
//        user.setUsername(userDto.getUsername());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(encoder.encode(userDto.getPassword()));
//
//        userRepository.save(user);
//    }
//
//  @PutMapping("/endiant/{id}")
//    public void endianUpdate(@RequestBody EtudientDto etudientDto, @PathVariable("id") int id) {
//        Etudient etudient = etudientRepo.findById(id).orElseThrow();
//          etudient.setIne(etudientDto.getIne());
//          etudient.setNom(etudientDto.getNom());
//          etudient.setPrenom(etudientDto.getPrenom());
//          etudient.setDate(etudientDto.getDate());
//          etudient.setEmail(etudientDto.getEmail());
//          etudient.setPassword(encoder.encode(etudientDto.getPassword()));
//          etudient.setInscription(etudientDto.getInscription());
//          etudient.setNiveau(etudientDto.getNiveau());
//          etudient.setEtablisement(etudientDto.getEtablisement());
//
//      etudientRepo.save(etudient);
//    }

        @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        etudientRepo.deleteById(id);
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