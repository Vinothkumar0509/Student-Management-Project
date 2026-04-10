package com.mentorhints.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/period-management")
public class PeriodController {

    @GetMapping("/getPeriod")
    public String getPeriod()
    {
        return "English-1,Maths-2,Break-2mins";
    }
}
