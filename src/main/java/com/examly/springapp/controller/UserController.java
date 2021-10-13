package com.examly.springapp.controller;

import com.examly.springapp.model.User;
import com.examly.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public boolean register(@RequestBody User user){
        return service.register(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody User user){
        return service.verifyLogin(user.getEmail(),user.getPassword());
    }



    @GetMapping("/getusers")
    public List<User> getusers(){
        return service.getusers();
    }



    @GetMapping("/delete")
    @Transactional
    public String delete(@RequestBody User user){
        return service.deleteUserByName(user.getEmail());
    }


    @GetMapping("/deleteID")
    @Transactional
    public String deletebyid(@RequestBody User user){
        return service.deletebyid(user.getId());
    }


    @PostMapping("/update")
    public String update(@RequestBody User user){
        return service.update(user);
    }
}
