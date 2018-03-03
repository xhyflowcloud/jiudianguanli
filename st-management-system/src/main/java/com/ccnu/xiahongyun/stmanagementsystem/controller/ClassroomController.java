package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService){
        this.classroomService = classroomService;
    }

    @PostMapping("/query")
    public ResponseEntity<ResponseData> login(@RequestBody ClassroomQuery classroomQuery) {

        //目标分页对象
        QueryViewPage<ClassroomTime> aimPage = new QueryViewPage<>();
        List<ClassroomTime> classroomsTime = new ArrayList<>();
        try {

            List<Classroom> classrooms = classroomService.findClassroomByClassroomQuery(classroomQuery);
            for (Classroom c: classrooms) {
                ClassroomTime classroomTime = new ClassroomTime();
                classroomTime.setId(c.getId());
                classroomTime.setSize(c.getSize());
                classroomTime.setPosition(c.getPosition());
                classroomTime.setEnable(c.getEnable());
                if(c.getStarttime() != null)classroomTime.setStarttime(new Date(c.getStarttime()).toString());
                if(c.getEndtime() != null)classroomTime.setEndtime(new Date(c.getEndtime()).toString());
                classroomsTime.add(classroomTime);
            }
            aimPage.setResults(classroomsTime);
            aimPage.setTotalRecord(classroomService.findClassroomCountByClassroomQuery(classroomQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(aimPage).build());
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());

        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> add(@RequestBody Classroom classroom) {

        try{
            if(classroomService.insertClassroom(classroom)){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseData> delete(@RequestBody Classroom classroom) {

        try{
            if(classroom.getId() != null && classroomService.deleteClassroomById(classroom.getId())){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseData> update(@RequestBody Classroom classroom) {

        try{
            if(classroomService.updateClassroom(classroom)){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(XHttpStatus.HTTP_SUCCESS.getMessage()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }
}