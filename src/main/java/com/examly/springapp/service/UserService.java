package com.examly.springapp.service;

import com.examly.springapp.dao.Userdao;
import com.examly.springapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    Userdao dao;

    public boolean register(User user){
        if(dao.save(user)!=null){
            return true;
        }
        return false;
    }
    public boolean verifyLogin(String username,String password){
        User user=dao.findByemail(username);
        if(user.getPassword().equals(password)){return true;}
        return false;
    }

    public List<User> getusers(){
        return dao.findAll();
    }



    public String deleteUserByName(String email){
        dao.deleteByemail(email);
        return "Deleted "+email+" username successfully";
    }

    public String deletebyid(int id){
        dao.deleteById(id);
        return "ID Deleted";
    }

    public String update(User user){
        User existinguser=dao.findByemail(user.getEmail());
        if(existinguser==null){return "NO USER";}
        System.out.println(existinguser.getEmail()+" is the existing user");
        existinguser.setPassword(user.getPassword());
        dao.save(existinguser);
        return "UPDATED SUCCESSFULLY";
    }


}
