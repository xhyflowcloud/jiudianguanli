package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.TeacherMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import com.ccnu.xiahongyun.stmanagementsystem.query.TeacherQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper){
        this.teacherMapper = teacherMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean insertTeacher(Teacher teacher) {
        Boolean isSuccess;
        try{
            teacher.setStarttime(new Date().getTime());
            teacher.setEndtime(new Date().getTime());
            teacherMapper.insertTeacher(teacher);
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean deleteTeacherById(Integer id) {
        Boolean isSuccess;
        Teacher teacher;
        try{
            teacher = teacherMapper.selectTeacherById(id);
            if(teacher.getEndtime() > new Date().getTime() && teacher.getStarttime() < new Date().getTime()){
                isSuccess = false;
            }else {
                teacherMapper.deleteTeacher(id);
                isSuccess = true;
            }
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean updateTeacher(Teacher teacher) {
        Boolean isSuccess;
        Teacher teacher1;
        try{
            teacher1 = teacherMapper.selectTeacherById(teacher.getId());
            if(teacher1.getEndtime() > new Date().getTime() && teacher1.getStarttime() < new Date().getTime()){
                isSuccess = false;
            }else {
                teacherMapper.updateTeacher(teacher);
                isSuccess = true;
            }
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Teacher> findTeacherByTeacherQuery(TeacherQuery teacherQuery) {
        List<Teacher> teachersList;

        try{
            teachersList = teacherMapper.findTeacherByLimit(teacherQuery);
        }catch (Exception e){
            teachersList = null;
        }
        return teachersList;
    }

    @Override
    public Integer findTeacherCountByTeacherQuery(TeacherQuery teacherQuery) {
        Integer count;

        try{
            count = teacherMapper.findTeacherCount(teacherQuery);
        }catch (Exception e){
            count = -1;
        }
        return count;
    }
}
