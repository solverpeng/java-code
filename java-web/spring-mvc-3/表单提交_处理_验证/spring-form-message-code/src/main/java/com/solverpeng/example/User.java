package com.solverpeng.example;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class User {
    private Long id;
    @Size(min = 5, max = 20, message = "{user.name.size}")
    private String name;
    @NotEmpty(message = "{user.email.empty}")
    @Email(message = "{user.email.empty}")
    private String email;
    @Size(min = 6, max = 20, message = "{user.password.size}")
    @Pattern(regexp = "\\S+", message = "{user.password.pattern}")
    private String password;
}
