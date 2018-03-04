package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.ClassroomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    private final ClassroomMapper classroomMapper;

    public ClassroomServiceImpl(ClassroomMapper classroomMapper){
        this.classroomMapper = classroomMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean insertClassroom(Classroom classroom) {
        Boolean isSuccess;
        try{
            classroom.setStarttime(new Date().getTime());
            classroom.setEndtime(new Date().getTime());
            classroom.setEnable(true);
            classroomMapper.insertClassroom(classroom);
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean deleteClassroomById(Integer id) {
        Boolean isSuccess;
        Classroom classroom;
        try{
            classroom = classroomMapper.findClassroomById(id);
            if(classroom.getEndtime() > new Date().getTime() && classroom.getStarttime() < new Date().getTime()){
                isSuccess = false;
            }else {
                classroomMapper.deleteClassroom(id);
                isSuccess = true;
            }
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean updateClassroom(Classroom classroom) {
        Boolean isSuccess;
        Classroom classroom1;
        try{
            classroom1 = classroomMapper.findClassroomById(classroom.getId());
            if(classroom1.getEndtime() > new Date().getTime() && classroom1.getStarttime() < new Date().getTime()){
                isSuccess = false;
            }else {
                classroomMapper.updateClassroom(classroom);
                isSuccess = true;
            }
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Classroom> findClassroomByClassroomQuery(ClassroomQuery classroomQuery) {
        List<Classroom> classroomList;

        try{
            classroomList = classroomMapper.findClassroomByLimit(classroomQuery);
        }catch (Exception e){
            classroomList = null;
        }
        return classroomList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer findClassroomCountByClassroomQuery(ClassroomQuery classroomQuery) {
        Integer count;

        try{
            count = classroomMapper.findClassroomCount(classroomQuery);
        }catch (Exception e){
            count = 0;
        }
        return count;
    }
}
