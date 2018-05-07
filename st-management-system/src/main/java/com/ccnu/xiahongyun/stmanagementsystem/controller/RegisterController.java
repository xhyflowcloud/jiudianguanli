package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenDetailImpl;
import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenUtils;
import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.Admin;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import com.ccnu.xiahongyun.stmanagementsystem.services.RegisterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class RegisterController {

    private final TokenUtils tokenUtils;
    private final RegisterService registerService;

    RegisterController(RegisterService registerService, TokenUtils tokenUtils){
        this.registerService = registerService;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody Admin admin){
        String token;
        try {
            Admin admin1 = registerService.SelectAdminByUsername(admin.getUsername());
            if(admin.getPassword().equals(admin1.getPassword())){
                tokenUtils.getUserList().add(admin.getUsername());
                token = tokenUtils.generateToken(new TokenDetailImpl(admin.getUsername()));
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(token).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_VERIFICATION.getCode()).data(XHttpStatus.HTTP_VERIFICATION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }
}
