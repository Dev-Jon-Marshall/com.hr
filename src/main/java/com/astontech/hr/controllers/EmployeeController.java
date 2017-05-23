package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jonathan.Marshall on 3/20/2017.
 */
@Controller
public class EmployeeController
{
    @RequestMapping("/employee")
    public String employeePage()
    {
        return "employee";
    }
}
