package com.solverpeng.example;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    private Long id;
    @Size(min = 5, max = 20)
    private String name;
    @NotEmpty
    @Email
    private String email;
    @Size(min = 6, max = 20)
    @Pattern(regexp = "\\S+", message = "不允许空格")
    private String password;
}
