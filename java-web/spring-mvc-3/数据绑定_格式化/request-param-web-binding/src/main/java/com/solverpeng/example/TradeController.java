package com.solverpeng.example;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/")
public class TradeController {
    @InitBinder("tradeDate")
    public void customizeBinding(WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(dateFormatter, true));
    }

    @GetMapping("/trade")
    @ResponseBody
    public String handleRequest(@RequestParam Date tradeDate) {
        return "request received for " + tradeDate;
    }
}
