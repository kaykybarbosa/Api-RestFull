package com.coursespringboot.Api.Rest.Full.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private LocalDate dob;
    @NotBlank
    private Integer age;
}
