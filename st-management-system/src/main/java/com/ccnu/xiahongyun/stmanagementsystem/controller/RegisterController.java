package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenDetailImpl;
import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenUtils;
import com.ccnu.xiahongyun.stmanagementsystem.enums.XHttpStatus;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.ResponseData;
import com.ccnu.xiahongyun.stmanagementsystem.services.RegisterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class RegisterController {

    private final RegisterService registerService;
    private final TokenUtils tokenUtils;

    RegisterController(RegisterService registerService, TokenUtils tokenUtils){
        this.registerService = registerService;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseData> register(@RequestBody Register register) {
        try {
            registerService.addRegister(register);
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).build());
        } catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseData> login(@RequestBody Register register){
        String token = "";
        try {
            Register registerTemp = registerService.findRegisterById(register.getEmail());
            if(registerTemp.getPwd().equals(register.getPwd())){
                tokenUtils.getUserList().add(register.getEmail());
                token = tokenUtils.generateToken(new TokenDetailImpl(register.getEmail()));
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_SUCCESS.getCode()).data(token).build());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().status(XHttpStatus.HTTP_VERIFICATION.getCode()).data(XHttpStatus.HTTP_VERIFICATION.getMessage()).build());
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(new ResponseData.Builder().buildFailureResponse());
        }
    }
}
