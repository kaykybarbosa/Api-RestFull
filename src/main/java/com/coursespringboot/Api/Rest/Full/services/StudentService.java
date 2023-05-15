package com.coursespringboot.Api.Rest.Full.services;

import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import com.coursespringboot.Api.Rest.Full.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }
    @Transactional
    public Object save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public Optional<StudentModel> findById(Long id) {
        return studentRepository.findById(id);
    }

    public void delete(StudentModel existsStudent) {
        studentRepository.delete(existsStudent);
    }
}
