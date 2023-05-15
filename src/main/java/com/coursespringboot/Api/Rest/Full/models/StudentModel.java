package com.coursespringboot.Api.Rest.Full.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentModel {

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;

    public StudentModel(long l, String kaio, String mail, LocalDate of, int i) {
    }
}
