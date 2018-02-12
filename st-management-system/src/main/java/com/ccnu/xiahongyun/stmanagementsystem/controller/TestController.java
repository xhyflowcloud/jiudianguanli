package com.ccnu.xiahongyun.stmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/check", method = GET)
    public String getCheck(){
        return "finish checked";
    }
}
