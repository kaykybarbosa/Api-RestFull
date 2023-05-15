package com.coursespringboot.Api.Rest.Full.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDto {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    @NotNull
    private LocalDate dob;
}
