package com.examly.springapp.dao;

import com.examly.springapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Employeedao extends JpaRepository<Employee,Integer> {

}
