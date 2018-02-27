package com.ccnu.xiahongyun.stmanagementsystem.controller;


import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.SubjectMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<List<SubjectItem>> add(@PathVariable String email) {

        Root root = null;
        Register register = null;
        List<SubjectItem> subjectItems = new ArrayList<SubjectItem>();
        List<Subject> subjects = null;
        try {
            if(email != null && StringUtils.isNotEmpty(email)) {

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(null);     //无该用户
                }
                subjects = subjectMapper.selectAllSubject();
                for (Subject subject: subjects) {
                    SubjectItem subjectItem = new SubjectItem();
                    subjectItem.setId(subject.getId());
                    subjectItem.setName(subject.getName());
                    subjectItems.add(subjectItem);
                }
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(subjectItems);

            }else{
                return null;
            }
        }catch(Exception e){
          throw e;
        }

    }
}
