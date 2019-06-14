package com.solverpeng.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

// 对于矩阵变量，需要开启支持，默认是关闭的
@RestController
@RequestMapping("/handlerMethod")
public class HandlerMethodMatrixVariablesController {


    // GET /matrixVariables/42;q=11;r=22
    @GetMapping("/matrixVariables/{petId}")
    public String matrixVariables(@PathVariable String petId, @MatrixVariable int q) {
        return "matrixVariables->petId:" + petId + ",q:" + q;
    }

    @GetMapping("/matrixVariables2/{ownerId}/{petId}")
    public String matrixVariables2(
            @MatrixVariable(name = "q", pathVar = "ownerId") int q1,
            @MatrixVariable(name = "q", pathVar = "petId") int q2 ) {
        return "matrixVariables->q1:" + q1 + ",q2:" + q2;
    }

    @GetMapping("/matrixVariables3/{ownerId}/pets/{petId}")
    public String matrixVariables2(
            @MatrixVariable MultiValueMap<String, String> matrixVars,
            @MatrixVariable(pathVar = "petId") MultiValueMap<String, String> petMatrixVars) {
        return "matrixVariables->matrixVars:" + matrixVars + ",petMatrixVars:" + petMatrixVars;
    }

}
