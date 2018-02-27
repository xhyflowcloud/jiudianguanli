package com.ccnu.xiahongyun.stmanagementsystem.controller;


import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.SubjectMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    RootMapper rootMapper;
    @Autowired
    RegisterMapper registerMapper;


    @PostMapping("/{email}/add")
    public ResponseEntity<Integer> add(@PathVariable String email, @RequestBody SubjectQuery subjectQuery) {

        Root root = null;
        Register register = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && subjectQuery != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                subjectMapper.insertSubject(subjectQuery.getName(),new Date().getTime(),new Date().getTime(),new Date().getTime(),new Date().getTime(),subjectQuery.getMaxnumber(),subjectQuery.getMinnumber());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);
    }


   /* @PostMapping("/{email}/delete")
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

                stu.deleteStudent(student.getExamid());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }*/
   /* @PostMapping("/{email}/update")
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
    }*/



}
