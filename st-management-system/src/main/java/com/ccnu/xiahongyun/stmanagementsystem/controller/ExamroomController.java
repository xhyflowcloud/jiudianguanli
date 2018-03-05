package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.Examroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import com.ccnu.xiahongyun.stmanagementsystem.query.ExamroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.services.ExamroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/examroom")
public class ExamroomController {

    private final ExamroomService examroomService;

    @Autowired
    public ExamroomController(ExamroomService examroomService) {
        this.examroomService = examroomService;
    }

    @PostMapping("/query")
    public ResponseEntity<ResponseData> query(@RequestBody ExamroomQuery examroomQuery){
        QueryViewPage<Examroom> aimPage = new QueryViewPage<>();
        try{
            aimPage.setResults(examroomService.findExamroomByQuery(examroomQuery));
            aimPage.setTotalRecord(examroomService.countExamroomByQuery(examroomQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(aimPage).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @GetMapping("/query/{examroomid}")
    public ResponseEntity<ResponseData> queryByExamroomId(@PathVariable Integer examroomid){
        try{
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(examroomService.findStudentByExamroomId(examroomid)).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }
}
