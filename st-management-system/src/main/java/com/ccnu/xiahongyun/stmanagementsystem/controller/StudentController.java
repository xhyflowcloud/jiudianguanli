package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper stu;



    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Student student){
        if(null!=stu.findStudentById(student.getExamid())){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("该考生已报名");
        }
        try{
            stu.insertStudent(student.getExamid(),student.getName(),student.getId(),student.getSid());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("添加失败");
        }
    }


    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody Student student){
        try{
            stu.deleteStudent(student.getExamid());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("删除失败");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody Student student){

        try{
            stu.updateStudent(student.getExamid(),student.getName(),student.getId(),student.getSid());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新成功");
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("更新失败");
        }
    }

    @PostMapping("/queryall")
    public ResponseEntity<List<Student>> queryall(){
       List<Student> students =stu.findAllStudent();
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(students);
    }

    @PostMapping("/queryone")
    public ResponseEntity<Student> queryone(@RequestBody Student student){
        Student student1 = stu.findStudentById(student.getExamid());
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(student1);
    }

}
