package com.ccnu.xiahongyun.stmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TestController {

    @RequestMapping("/hello")
    public  String hello(@RequestParam(value = "name", required = false, defaultValue = "hello") String name, Model model){
        model.addAttribute("name",name);
        return "pop";
    }
}
