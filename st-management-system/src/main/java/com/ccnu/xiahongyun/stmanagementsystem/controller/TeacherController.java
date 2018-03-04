package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.TeacherMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.TeacherQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> add(@RequestBody Teacher teacher) {

        try{
            if(teacherService.insertTeacher(teacher)){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseData> delete(@RequestBody Teacher teacher) {

        try{
            if(teacher.getId() != null && teacherService.deleteTeacherById(teacher.getId())){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }


    @PostMapping("/update")
    public ResponseEntity<ResponseData> update(@RequestBody Teacher teacher) {

        try{
            if(teacherService.updateTeacher(teacher)){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/query")
    public ResponseEntity<ResponseData> login(@RequestBody TeacherQuery teacherQuery) {

        try {
            //目标分页对象
            QueryViewPage<TeacherTime> aimPage = new QueryViewPage<>();
            List<TeacherTime> teacherTimes= new ArrayList<>();

            List<Teacher> teachers = teacherService.findTeacherByTeacherQuery(teacherQuery);
            for (Teacher c: teachers) {
                TeacherTime teacherTime = new TeacherTime();
                teacherTime.setId(c.getId());
                teacherTime.setName(c.getName());
                if(c.getStarttime() != null)teacherTime.setStarttime(new Date(c.getStarttime()).toString());
                if(c.getEndtime() != null)teacherTime.setEndtime(new Date(c.getEndtime()).toString());
                teacherTime.setInvigilator(c.getInvigilator());
                teacherTime.setNumInvigilator(c.getNumInvigilator());
                teacherTime.setAccInvigilator(c.getAccInvigilator());

                teacherTimes.add(teacherTime);
            }
            aimPage.setResults(teacherTimes);
            aimPage.setTotalRecord(teacherService.findTeacherCountByTeacherQuery(teacherQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(aimPage).build());
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }
}
