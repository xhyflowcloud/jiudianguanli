package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.TeacherMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherMapper tea;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Teacher teacher){
        if(null!= tea.selectTeacherByName(teacher.getName())){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("该教师已存在");
        }
        try{
            tea.insertTeacher(teacher.getName(),teacher.getInvigilator(),teacher.getNumInvigilator(),teacher.getAccInvigilator());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加失败");
        }

    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Teacher teacher){
        try{
            tea.deleteTeacher(teacher.getId());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除失败");
        }
    }


    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Teacher teacher){
        if(null!= tea.selectTeacherByName(teacher.getName())){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("该教师已存在");
        }
        try{
            tea.updateTeacher(teacher.getId(),teacher.getName(),teacher.getInvigilator(),teacher.getNumInvigilator(),teacher.getAccInvigilator());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新失败");
        }
    }

    @PostMapping("/queryone")
    public ResponseEntity<Teacher> queryone(@RequestBody Teacher teacher){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(tea.selectTeacherById(teacher.getId()));
    }



    @PostMapping("/queryall")
    public ResponseEntity<List<Teacher>> queryall(){
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(tea.selectAllTeacher());
    }
}
