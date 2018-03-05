package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.SubjectService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/querysubjects")
    public ResponseEntity<ResponseData> getSubjects(){

        try {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(subjectService.findAllSubjects()).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseData> add(@RequestBody SubjectTest subjectTest){

        try {
            if(subjectService.insertSubject(subjectTest)) {
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(subjectService.findAllSubjects()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_REFUSE.getCode()).data(XHttpStatus.HTTP_REFUSE.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseData> delete(@RequestBody SubjectTest subjectTest){

        try {
            if(subjectService.deleteSubject(subjectTest)) {
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(subjectService.findAllSubjects()).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_REFUSE.getCode()).data(XHttpStatus.HTTP_REFUSE.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }

    @PostMapping("/query")
    public ResponseEntity<ResponseData> query(@RequestBody SubjectQuery subjectQuery){

        QueryViewPage<SubjectString> aimPage = new QueryViewPage<>();
        try{
            aimPage.setResults(subjectService.findSubjectBySubjectQuery(subjectQuery));
            aimPage.setTotalRecord(subjectService.countSubjectBySubjectQuery(subjectQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(aimPage).build());
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
        }
    }
}
