package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherMapper tea;

    @RequestMapping("/addteacher")
    @ResponseBody
    public String addteacher(@RequestParam("name") String name,@RequestParam("isInvigilator") Boolean isInvigilator,
                             @RequestParam("numInvigilator") Integer numInvigilator,@RequestParam("accInvigilator") Boolean accInvigilator){
        tea.insertTeacher(name,isInvigilator,numInvigilator,accInvigilator);

        return "操作成功";

    }

    @RequestMapping("/deleteteacher")
    @ResponseBody
    public String deleteteacher(@RequestParam("id") Integer id){
        tea.deleteTeacher(id);
        return "操作成功";
    }
    @RequestMapping("/updateteacher")
    @ResponseBody
    public String updateteacher(@RequestParam("id") Integer id,@RequestParam("name") String name,@RequestParam("isInvigilator") Boolean isInvigilator,
                                @RequestParam("numInvigilator") Integer numInvigilator,@RequestParam("accInvigilator") Boolean accInvigilator){
        tea.updateTeacher(id,name,isInvigilator,numInvigilator,accInvigilator);
        return "操作成功";
    }
}
