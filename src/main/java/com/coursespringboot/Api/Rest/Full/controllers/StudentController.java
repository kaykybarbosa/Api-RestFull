package com.coursespringboot.Api.Rest.Full.controllers;

import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import com.coursespringboot.Api.Rest.Full.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path= "api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<StudentModel> getAll(){
        return studentService.findAll();
    }

}
