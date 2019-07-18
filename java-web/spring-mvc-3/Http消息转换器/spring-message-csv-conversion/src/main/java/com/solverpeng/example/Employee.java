package com.solverpeng.example;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Employee {
    @CsvBindByName
    private String id;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String phoneNumber;
}
