package com.examly.springapp.dao;

import com.examly.springapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userdao extends JpaRepository<User,Integer> {
    User findByemail(String email);
    String deleteByemail(String email);
}
