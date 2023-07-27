package com.shuubham.controller;

import com.shuubham.exception.UserNotFountException;
import com.shuubham.model.User;
import com.shuubham.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    @GetMapping("/user")
    List<User> getUser(){
        return userRepository.findAll();
    }
    @GetMapping("/user/{id}")
    User getUserById(@PathVariable long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFountException(id));
    }
    @PutMapping("/user/{id}")
    User updateUserById(@RequestBody User newUser, @PathVariable long id){
        return userRepository.findById(id).map(user ->{
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(()-> new UserNotFountException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteById(@PathVariable long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFountException(id);
        }
        userRepository.deleteById(id);
        return "user with id " + id +" deleted successfully";
    }

}
