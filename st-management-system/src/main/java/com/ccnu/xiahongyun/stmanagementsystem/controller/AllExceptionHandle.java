package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AllExceptionHandle {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<ResponseData> exceptionHandle(Exception e){
		e.printStackTrace();
		return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_EXCEPTION.getCode()).data(XHttpStatus.HTTP_EXCEPTION.getMessage()).build());
	}
}
