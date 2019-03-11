package com.lattice.latticemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lattice.latticemail.service.impl.MailServiceImpl;

/**
 * @program: lattice
 * @description: ${description}
 * @author: 张家豪
 * @create: 2018-11-26 21:45
 **/
@RestController
@RequestMapping("/mail")
public class MailController {
    
    @Autowired
    private MailServiceImpl mailService;
    
    @PostMapping("/")
    public Boolean sendSimpleMessage(@RequestParam String to, @RequestParam String action, @RequestParam String data) {
        
        try {
            mailService.sendTemplateMail(to, action, data);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
    
    @PostMapping("/code")
    public String sendCode(@RequestParam String to, @RequestParam String action) {
        return "";
    }
}
