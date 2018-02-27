package com.ccnu.xiahongyun.stmanagementsystem.controller;


import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper stu;
    @Autowired
    RootMapper rootMapper;
    @Autowired
    RegisterMapper registerMapper;


    @PostMapping("/{email}/add")
    public ResponseEntity<Integer> add(@PathVariable String email, @RequestBody Student student) {

        Root root = null;
        Register register = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && student!= null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root == null || root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                stu.insertStudent(student.getExamid(),student.getName(),student.getId(),student.getSid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);
    }


    @PostMapping("/{email}/delete")
    public ResponseEntity<Integer> delete(@PathVariable String email, @RequestBody Student student) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && student != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                stu.deleteStudent(student.getExamid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }
    @PostMapping("/{email}/update")
    public ResponseEntity<Integer> update(@PathVariable String email, @RequestBody Student student) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && student != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                stu.updateStudent(student.getExamid(),student.getName(),student.getId(),student.getSid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }



    @PostMapping("/query")
    public ResponseEntity<QueryViewPage<Student>> login(@RequestBody StudentQuery student) {

        try {
            //目标分页对象
            QueryViewPage<Student> aimPage = new QueryViewPage<Student>();
            List<Student> students = stu.findStudentByLimit(student);
            aimPage.setResults(students);
            aimPage.setTotalRecord(stu.findStudentCount(student));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(aimPage);
        }catch (Exception e) {
            throw e;
        }
    }



}
