package com.example.hw14.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.context.annotation.Role;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class EmpModel {
@NotEmpty(message = "can not be empty")
@Size(min=3,message = "can not be less than 3 index")
    private String id;

@NotEmpty(message = "can not be empty")
@Size(min=5,message = "can not be less than 5 index")
private String name;

    @NotNull(message = " can not be null")
    @Max(value = 25,message = "can not be more than 25")
    @Min(value = 0,message =  "can not be less than zero")
private int age;

    @NotEmpty(message = "can not be empty")
@Pattern(regexp = "(supervisor|coordinator)",message ="must be supervisor or coordinator")
    private String position ;

    @AssertFalse
    private boolean onLeave;

    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    @PastOrPresent
    private LocalDate employmentYear;


    @NotNull(message = " can not be null")
    private int annualLeave;



}
