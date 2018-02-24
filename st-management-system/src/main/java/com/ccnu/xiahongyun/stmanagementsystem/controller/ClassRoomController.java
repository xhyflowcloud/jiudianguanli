package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/classroom")
public class ClassRoomController {
    @Autowired
    ClassroomMapper cr;



    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Classroom room  ) {
        try {
            cr.insertClassroom(room.getSize(),room.getPosition());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加成功");
        } catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加失败");
        }
    }



    @RequestMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Classroom room){
        try {
            cr.deleteClassroom(room.getId());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除成功");
        } catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除失败");
        }
    }


    @RequestMapping("/queryall")
    public ResponseEntity<List <Classroom>> queryall(){

        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(cr.findAllClassroom());
    }



    @RequestMapping("/queryone")

    public ResponseEntity<Classroom> queryone(@RequestBody Classroom room){

        return  ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(cr.findClassroomById(room.getId()));

    }


    @RequestMapping("/update")

    public ResponseEntity<String> update(@RequestBody Classroom room){
       try{
           cr.updateClassroom(room.getSize(),room.getPosition(),room.getId());
           return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新成功");
       }
       catch (Exception e){
           return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新失败");
       }
    }

}
