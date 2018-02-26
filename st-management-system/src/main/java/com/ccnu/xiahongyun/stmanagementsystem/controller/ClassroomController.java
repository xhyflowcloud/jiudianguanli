package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    ClassroomMapper classroomMapper;
    @Autowired
    RootMapper rootMapper;
    @Autowired
    RegisterMapper registerMapper;

    @PostMapping("/query")
    public ResponseEntity<QueryViewPage<Classroom>> login(@RequestBody ClassroomQuery classroomQuery) {

        try {
            //目标分页对象
            QueryViewPage<Classroom> aimPage = new QueryViewPage<Classroom>();
            List<Classroom> classrooms = classroomMapper.findClassroomByLimit(classroomQuery);
            aimPage.setResults(classrooms);
            aimPage.setTotalRecord(classroomMapper.findAllClassroomCount());
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(aimPage);
        }catch (Exception e) {
            throw e;
        }
    }

    @PostMapping("/{email}/add")
    public ResponseEntity<Integer> add(@PathVariable String email, @RequestBody Classroom classroom) {

        Root root = null;
        Register register = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && classroom != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root == null || root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                classroomMapper.insertClassroom(classroom.getSize(), classroom.getPosition(), false);
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);
    }

    @PostMapping("/{email}/delete")
    public ResponseEntity<Integer> delete(@PathVariable String email, @RequestBody Classroom classroom) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && classroom != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                classroomMapper.deleteClassroom(classroom.getId());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }

    @PostMapping("/{email}/update")
    public ResponseEntity<Integer> update(@PathVariable String email, @RequestBody Classroom classroom) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && classroom != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);
                /*if(root.getAuth() < 10){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(3);  //无权限
                }*/
                classroomMapper.updateClassroom(classroom.getSize(), classroom.getPosition(), classroom.getEnable(), classroom.getId());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }
}