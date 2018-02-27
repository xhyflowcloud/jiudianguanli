package com.ccnu.xiahongyun.stmanagementsystem.controller;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.RegisterMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.RootMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.TeacherMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Register;
import com.ccnu.xiahongyun.stmanagementsystem.model.Root;
import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import com.ccnu.xiahongyun.stmanagementsystem.model.TeacherTime;
import com.ccnu.xiahongyun.stmanagementsystem.query.QueryViewPage;
import com.ccnu.xiahongyun.stmanagementsystem.query.TeacherQuery;
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
    @Autowired
    TeacherMapper tea;
    @Autowired
    RootMapper rootMapper;
    @Autowired
    RegisterMapper registerMapper;

    @PostMapping("/{email}/add")
    public ResponseEntity<Integer> add(@PathVariable String email, @RequestBody Teacher teacher) {

        Root root = null;
        Register register = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && teacher != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);

                tea.insertTeacher(teacher.getName(),new Date().getTime(),
                        new Date().getTime(),teacher.getInvigilator(),teacher.getNumInvigilator(),teacher.getAccInvigilator());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);
    }

    @PostMapping("/{email}/delete")
    public ResponseEntity<Integer> delete(@PathVariable String email, @RequestBody Teacher teacher) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && teacher != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);

               tea.deleteTeacher(teacher.getId());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }


    @PostMapping("/{email}/update")
    public ResponseEntity<Integer> update(@PathVariable String email, @RequestBody Teacher teacher) {

        Register register = null;
        Root root = null;

        try {
            if(email != null && StringUtils.isNotEmpty(email) && teacher != null){

                register = registerMapper.findRegisterByEmail(email);
                if(register == null){
                    return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(4);     //无该用户
                }
                root = rootMapper.findRootByEmail(email);

                tea.updateTeacher(teacher.getId(),teacher.getName(),new Date().getTime(),
                        new Date().getTime(),teacher.getInvigilator(),teacher.getNumInvigilator(),teacher.getAccInvigilator());
            }else{
                return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(2);
            }
        }catch (Exception e) {
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(0);
        }
        return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(1);

    }

    @PostMapping("/query")
    public ResponseEntity<QueryViewPage<TeacherTime>> login(@RequestBody TeacherQuery teacherQuery) {

        try {
            //目标分页对象
            QueryViewPage<TeacherTime> aimPage = new QueryViewPage<TeacherTime>();
            List<TeacherTime> teacherTimes= new ArrayList<TeacherTime>();

            List<Teacher> teachers = tea.findTeacherByLimit(teacherQuery);
            for (Teacher c: teachers) {
                TeacherTime teacherTime = new TeacherTime();
                teacherTime.setId(c.getId());
                teacherTime.setName(c.getName());
                teacherTime.setStarttime(new Date(c.getStarttime()).toString());
                teacherTime.setEndtime(new Date(c.getEndtime()).toString());
                teacherTime.setInvigilator(c.getInvigilator());
                teacherTime.setNumInvigilator(c.getNumInvigilator());
                teacherTime.setAccInvigilator(c.getAccInvigilator());

                teacherTimes.add(teacherTime);
            }
            aimPage.setResults(teacherTimes);
            aimPage.setTotalRecord(tea.findTeacherCount(teacherQuery));
            return ResponseEntity.ok().contentType(MediaType.valueOf("text/plain;charset=UTF-8")).body(aimPage);
        }catch (Exception e) {
            throw e;
        }
    }
}
