package com.solverpeng.example;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
public class UserList {
    private List<User> users;
}
