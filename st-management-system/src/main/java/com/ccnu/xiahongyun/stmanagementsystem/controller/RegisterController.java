package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/index")
public class RegisterController {

    @Autowired
    RegisterMapper registerMapper;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Register register) {
        try {
            if(null != registerMapper.findRegisterByEmail(register.getEmail())){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("该邮箱已经被注册");
            }
            else{
                registerMapper.insertRegister(register.getName(), register.getEmail(), register.getPwd());
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("注册成功");
            }
        } catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("注册失败");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Register register){

        try {
            Register register1 = registerMapper.findRegisterByEmail(register.getEmail());
            if(null == register1){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("没有该用户");
            }
            else if(register1.getPwd().equals(register.getPwd())){
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("登录成功");
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("密码错误");
            }
        }catch (Exception e){
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body("数据库异常");
        }
    }

}
