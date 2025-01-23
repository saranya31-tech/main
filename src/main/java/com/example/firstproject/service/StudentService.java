package com.example.firstproject.service;

import com.example.firstproject.exception.UserNotFoundException;
import com.example.firstproject.model.Registration;
import com.example.firstproject.repository.Jparepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    Jparepo jpa;

    public Registration addData(Registration regi){
        return jpa.save(regi);
    }

    public List<Registration> getData(){
        return jpa.findAll();
    }

    public Optional<Registration> getDataById(Integer id){
       return this.jpa.findById(id);
    }

    public Registration updateData(Integer id,Registration regi){
        Registration oldRecords = this.jpa.findById(id)
                        .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        oldRecords.setName(regi.name);
        oldRecords.setAddress(regi.address);
        oldRecords.setDepartment(regi.department);
        return this.jpa.save(oldRecords);
    }

    public String deleteById(Integer id){
        this.jpa.deleteById(id);
        return "Deleted Sucessfully";
    }
}
