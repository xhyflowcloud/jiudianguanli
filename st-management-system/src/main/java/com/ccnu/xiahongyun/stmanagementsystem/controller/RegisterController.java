package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    RegisterMapper regist;

 @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }


    @ResponseBody
    @RequestMapping(value="/regist",produces = "application/json;charset=utf-8")
    public String regist(@RequestParam("name") String name,@RequestParam("email") String email,
                         @RequestParam("pwd") String pwd){

        regist.insertRegister(name,email,pwd);
        return "注册成功";

    }


    @RequestMapping("/login")
    public String login(@RequestParam("email") String email,@RequestParam("pwd") String pwd){
       Register re= regist.findRegisterByEmail(email);
       if(re.getPwd().equals(pwd)){
           return "";
       }
       if(re==null){
           return "";
       }
       return "";
    }








    @ResponseBody
    @RequestMapping(value="/get",produces = "application/json;charset=utf-8" ,method = { RequestMethod.POST })
    public String get(@RequestBody Student ss){
        System.out.println(ss);
        return "s";
    }
    @ResponseBody
    @RequestMapping(value="/get2")
    public String get(@RequestParam("name") String name,@RequestParam("id") Integer id){
        System.out.println(name+id);
        return "s";
    }
}
