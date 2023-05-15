package com.coursespringboot.Api.Rest.Full.controllers;

import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
public class StudentController {

    public List<StudentModel> getAll(){
        return List.of(
                new StudentModel(1L,"Kaio", "Kaio@gmail.com", LocalDate.of(2000, Month.MARCH, 15 ),20)
        );
    }

}
