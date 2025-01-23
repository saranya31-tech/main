package com.example.firstproject.controller;

import com.example.firstproject.model.Registration;
import com.example.firstproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagesHome")
public class HomeContoller {

    @Autowired
    StudentService studentService;

    @PostMapping("/registration")
     public Registration addValues(@RequestBody Registration regi){
        return studentService.addData(regi);
    }

    @GetMapping("/getAllData")
    public List<Registration> getAllData(){
        return this.studentService.getData();
    }

    @GetMapping("/getById/{id}")
    public Optional<Registration> getById(@PathVariable (value = "id") Integer id){
        return this.studentService.getDataById(id);
    }

    @GetMapping("updateRegistration/{id}")
    public Registration updateRegistration(@PathVariable (value = "id") Integer id,
                                           @RequestBody Registration regi){
        return this.studentService.updateData(id,regi);
    }

    @DeleteMapping("deleteRegistartion/{id}")
    public String deleteRegis(@PathVariable (value = "id")Integer id){
        return this.studentService.deleteById(id);
    }
}
