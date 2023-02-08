package org.top.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.top.service.UserService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String createOrder(){
        String user = userService.getUser();
        return user + "create order success";
    }

    @GetMapping("/select")
    public String selectOrder(){
        String user = userService.getUser();
        return user + "select user success";
    }
}
