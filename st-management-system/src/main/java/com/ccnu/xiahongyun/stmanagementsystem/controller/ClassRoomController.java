package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    ClassroomMapper cr;



    @RequestMapping("/addclassroom")
    @ResponseBody
    public String addClassRoom(@RequestParam("size") Integer size,@RequestParam("position") String position){
        cr.insertClassroom(size,position);
        return "增加教室成功";
    }
    @RequestMapping("/deleteclassroom")
    @ResponseBody
    public String deleteClassRoom(@RequestParam("id") Integer id){
        cr.deleteClassroom(id);
        return "删除教室成功";
    }
    @RequestMapping("/queryclassrooms")
    @ResponseBody
    public String queryClassRooms(){
        List<Classroom> classrooms = cr.findAllClassroom();
        String jsonstring = JSONObject.toJSONString(classrooms);
        return jsonstring;
    }
    @RequestMapping("/queryclassroom")
    @ResponseBody
    public String queryClassRoom(@RequestParam("id") Integer id){
       Classroom classroom = cr.findClassroomById(id);
        String jsonstring = JSONObject.toJSONString(classroom);
        return jsonstring;
    }


    @RequestMapping("/updateclassroom")
    @ResponseBody
    public String updateClassRoom(@RequestParam("size") Integer size,@RequestParam("position") String position,
                                  @RequestParam("id") Integer id){
       cr.updateClassroom(size,position,id);
        return "更新教室成功";
    }

}
