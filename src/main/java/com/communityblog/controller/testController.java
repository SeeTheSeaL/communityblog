package com.communityblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }


    @RequestMapping("/login")
    public String toLogin(Model model){
        model.addAttribute("msg","message");
        return "login";
    }



}
