package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ValidEmployee {

    @NotNull(message = "Enter a valid Employee Id")
    private Long empId;

    @NotEmpty(message = "Phone number Must not be Empty and NULL")
    private String phoneNumber;

    @NotBlank(message = "Employee name can't be left empty")
    private String employeeName;

    @Min(value = 18, message = "Minimum working age 18")
    @Max(value = 60, message = "Maximum working age 60")
    private Integer age;

    @Email(message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be NULL")
    private String emailId;

    @Pattern(regexp = "^[0-9]{5}$", message = "Employee postal code must be a 5-digit number")
    private String employeePostalCode;

    @Size(
        min = 10, max = 100,
        message = "Address should have a length between 10 and 100 characters"
    )
    private String employeeAddress;
}
