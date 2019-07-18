package com.solverpeng.example;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement
public class User implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String emailAddress;
}
