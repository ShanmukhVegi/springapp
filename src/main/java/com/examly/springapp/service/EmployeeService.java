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

    public Employee getEmployeeByID(String username){

        System.out.println(username+" is the username !!!!!!!!!!");
        Employee result=dao.findByUsername(username);
        if(result==null){return null;}

        System.out.println(result.getUsername()+" is the username");
        return result;
    }

    public Employee editEmployee(Employee employee){
        Employee existingEmployee=dao.findByUsername(employee.getUsername());
        if(existingEmployee==null){return null;}
        existingEmployee.setVehicleNumber(employee.getVehicleNumber());
        existingEmployee.setVehicleModel(employee.getVehicleModel());
        existingEmployee.setUsername(employee.getUsername());
        existingEmployee.setMobileNumber(employee.getMobileNumber());
        existingEmployee.setPassword(employee.getPassword());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setActive(employee.isActive());
        existingEmployee.setVerified(employee.isVerified());
        dao.save(existingEmployee);
        return existingEmployee;

    }

    public boolean saveEmployee(Employee employee){
        Employee existing=dao.findByUsername(employee.getUsername());
        if(existing!=null){return false;}
        dao.save(employee);
        return true;
    }

    public String deleteEmployee(String username){
        if(dao.deleteByUsername(username)!=null){
            return "Deleted";}
        return "Error in deleting";
    }






}
