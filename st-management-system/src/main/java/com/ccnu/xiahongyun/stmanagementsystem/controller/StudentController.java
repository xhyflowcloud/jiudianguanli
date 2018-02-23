package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper stu;


    @ResponseBody
    @RequestMapping("/addstudent")
    public String addstudent(@RequestParam("examid") Integer examid,@RequestParam("name") String name,
                             @RequestParam("id") Integer id,@RequestParam("sid") Integer sid){

        stu.insertStudent(examid,name,id,sid);
        return "操作成功";
    }

    @ResponseBody
    @RequestMapping("/deletestudent")
    public String deletestudent(@RequestParam("examid") Integer examid){
        stu.deleteStudent(examid);
        return "操作成功";
    }

    @RequestMapping("/updatestudent")
    @ResponseBody
    public String updatestudent(@RequestParam("examid") Integer examid,@RequestParam("name") String name,@RequestParam("id") Integer id,@RequestParam("sid") Integer sid){
        stu.updateStudent(examid,name,id,sid);
        return "操作成功";
    }

    @RequestMapping("/querystudents")
    @ResponseBody
    public String querystudents(){
       List<Student> students =stu.findAllStudent();
       String jsonstring = JSONObject.toJSONString(students);
       return  jsonstring;
    }

    @RequestMapping("/querystudent")
    @ResponseBody
    public String querystudent(@RequestParam("examid") Integer examid){
        Student student =stu.findStudentById(examid);
        String jsonstring = JSONObject.toJSONString(student);
        return  jsonstring;
    }

}
