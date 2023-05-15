package com.coursespringboot.Api.Rest.Full.controllers;

import com.coursespringboot.Api.Rest.Full.dtos.StudentDto;
import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import com.coursespringboot.Api.Rest.Full.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping(path= "api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<StudentModel> getAll(){
        return studentService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> sabeStudent(@RequestBody @Valid StudentDto studentDto){
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        studentModel.setDob(LocalDate.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }

}
