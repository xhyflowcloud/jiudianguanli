package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping("/refuse")
    public ResponseEntity<ResponseData> refuse(){
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_REFUSE.getCode()).data(XHttpStatus.HTTP_REFUSE.getMessage()).build());
    }

    @GetMapping("/verification")
    public ResponseEntity<ResponseData> verification(){
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_VERIFICATION.getCode()).data(XHttpStatus.HTTP_VERIFICATION.getMessage()).build());
    }

    @GetMapping("/authority")
    public ResponseEntity<ResponseData> authority(){
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_AUTHORITY.getCode()).data(XHttpStatus.HTTP_AUTHORITY.getMessage()).build());
    }

    @GetMapping("/exception")
    public ResponseEntity<ResponseData> exception(){
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
    }
}


