package com.examly.springapp.service;

import com.examly.springapp.dao.Employeedao;
import com.examly.springapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    Employeedao dao;

    public List<Employee> getEmployees(){
        return dao.findAll();
    }

    


}
