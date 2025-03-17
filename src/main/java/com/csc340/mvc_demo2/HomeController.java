package com.csc340.mvc_demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

     @GetMapping({"", "/", "/home", "dashboard"})
    public String showDashBoard(){
        return "redirect:/students/all";
    }
}
