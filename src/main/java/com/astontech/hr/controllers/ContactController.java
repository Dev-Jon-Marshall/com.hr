package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jonathan.Marshall on 3/27/2017.
 */
@Controller

public class ContactController
{
    @RequestMapping("/contact")
    public String contactPage()
    {
        return "contact";
    }
}
