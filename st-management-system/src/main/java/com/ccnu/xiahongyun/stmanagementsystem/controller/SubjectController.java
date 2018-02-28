package com.ccnu.xiahongyun.stmanagementsystem.controller;


import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.SubjectMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
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

    @GetMapping("/{email}/querysubjects")
    public ResponseEntity<List<Subject>> get(@PathVariable String email){

        Register register = null;
        Root root = null;
        List<Subject> subjects = new ArrayList<Subject>();
        List<Subject> subjectstemp = null;
        try{
            if(email != null && StringUtils.isNotEmpty(email)){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(null);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root == null || root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/

                subjectstemp = subjectMapper.selectAllSubject();
                /*for (Subject subject: subjectstemp) {
                    if(subject.getBmendtime() < new Date().getTime() || subject.getBmstarttime() > new Date().getTime()){
                        continue;
                    }
                    else{
                        subjects.add(subject);
                    }
                }*/
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(subjectstemp);

            }else {
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(null);
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(null);
        }
    }
}
