package com.ccnu.xiahongyun.stmanagementsystem.controller;


import com.ccnu.xiahongyun.stmanagementsystem.mapper.*;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

   /* @Autowired
    StudentMapper studentMapper;
    @Autowired
    RootMapper rootMapper;
    @Autowired
    RegisterMapper registerMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    StudentInfoMapper studentInfoMapper;
    @Autowired
    StudentexamroominfoMapper studentexamroominfoMapper;


   @PostMapping("/{email}/add")
    public ResponseEntity<Integer> add(@PathVariable String email, @RequestBody StudentExpand studentExpand) {

        Root root = null;
        Register register = null;
        Subject subject = null;


        try {
            if(email != null && StringUtils.isNotEmpty(email) && studentExpand != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                *//*if(root == null || root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*//*
                subject = subjectMapper.selectSubjectById(studentExpand.getSubjectid());
                if(subject.getBmendtime() < new Date().getTime()){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(5);  //报名截止     //无该用户
                }
                studentMapper.insertStudent(studentExpand.getName(),studentExpand.getId(), studentExpand.getSid());
                studentInfoMapper.insertStudentInfo(studentExpand.getSubjectid(), studentExpand.getSid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);
    }


    @PostMapping("/{email}/delete")
    public ResponseEntity<Integer> delete(@PathVariable String email, @RequestBody StudentExpand studentExpand) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && studentExpand != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                *//*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*//*
                studentInfoMapper.deleteStudentInfoByStudentId(studentExpand.getSid());
                studentMapper.deleteStuden t(studentExpand.getSid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }
    @PostMapping("/{email}/update")
    public ResponseEntity<Integer> update(@PathVariable String email, @RequestBody StudentExpand studentExpand) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && studentExpand != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                *//*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*//*
                studentMapper.updateStudent(studentExpand.getName(),studentExpand.getId(),studentExpand.getSid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }



   @PostMapping("/query")
    public ResponseEntity<QueryViewPage<Student>> login(@RequestBody StudentQuery studentQuery) {

        Studentexamroominfo studentexamroominfo = null;
        try {
            //目标分页对象
            QueryViewPage<Student> aimPage = new QueryViewPage<Student>();
            List<Student> students = studentMapper.findStudentByLimit(studentQuery);
            List<StudentExpand> studentExpands = new ArrayList<StudentExpand>();
            for (Student student: students) {

            }

            aimPage.setResults(students);
            aimPage.setTotalRecord(stu.findStudentCount(studentQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(aimPage);
        }catch (Exception e) {
            throw e;
        }
    }


*/
}
