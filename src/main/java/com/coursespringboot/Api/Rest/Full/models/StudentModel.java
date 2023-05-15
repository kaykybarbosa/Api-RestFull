package com.coursespringboot.Api.Rest.Full.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="tb_student")
public class StudentModel implements Serializable {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private Integer age;
}