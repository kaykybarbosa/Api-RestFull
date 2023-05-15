package com.coursespringboot.Api.Rest.Full.repositories;

import com.coursespringboot.Api.Rest.Full.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}
