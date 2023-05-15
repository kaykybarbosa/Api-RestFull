package com.coursespringboot.Api.Rest.Full.services;

import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import com.coursespringboot.Api.Rest.Full.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }
}
