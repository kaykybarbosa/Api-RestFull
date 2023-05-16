package com.coursespringboot.Api.Rest.Full.controllers;

import com.coursespringboot.Api.Rest.Full.dtos.StudentDto;
import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import com.coursespringboot.Api.Rest.Full.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentDto studentDto){
        if (studentService.existsByEmail(studentDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" Email already registered.");
        }

        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        studentModel.setAge(Period.between(studentDto.getDob(), LocalDate.now()).getYears());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "id") Long id){
        Optional<StudentModel> existsStudent = studentService.findById(id);
        if(!existsStudent.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Student not found.");
        }

        studentService.delete(existsStudent.get());
        return ResponseEntity.status(HttpStatus.OK).body(" Student deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value="id") Long id,
                                                @RequestBody @Valid StudentDto studentDto){
        Optional<StudentModel> studentModelOptical = studentService.findById(id);
        if(!studentModelOptical.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" Student not found.");
        }
        if (studentService.existsByEmail(studentDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(" Email already registered.");
        }

        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        studentModel.setId(studentModelOptical.get().getId());
        studentModel.setAge(Period.between(studentModelOptical.get().getDob(), LocalDate.now()).getYears());
        return ResponseEntity.status(HttpStatus.OK).body(studentService.save(studentModel));
    }
}
