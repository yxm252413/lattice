package com.lattice.latticezuul.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(Model model){
        System.out.println("*************************************");
        model.addAttribute("name","zhangjiahao");
        return "/index";

    }
}
