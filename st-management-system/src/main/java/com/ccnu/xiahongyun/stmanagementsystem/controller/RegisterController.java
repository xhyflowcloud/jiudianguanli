package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @RequestMapping(value="/hello")
    public String hello(){
        return "hello";
    }



    @ResponseBody
    @RequestMapping(value="/regist",produces = "application/json;charset=utf-8")
    public String regist(){
        Student s = new Student();
        s.setSid(1111);
        s.setName("冯越");
        s.setExamid(111111111);
        String jsonString = JSONObject.toJSONString(s);
        return jsonString;
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
