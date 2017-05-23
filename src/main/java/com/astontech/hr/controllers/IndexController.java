package com.astontech.hr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
@Controller
public class IndexController
{
    @RequestMapping(value= "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value ="/login")
    public String login()
    {
        return "login";
    }
}
