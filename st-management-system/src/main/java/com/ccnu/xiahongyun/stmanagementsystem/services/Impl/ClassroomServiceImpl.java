package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.ClassroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.services.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService{

    private final ClassroomMapper classroomMapper;

    public ClassroomServiceImpl(ClassroomMapper classroomMapper){
        this.classroomMapper = classroomMapper;
    }

    @Override
    public boolean insertClassroom(Classroom classroom) {
        Boolean isSuccess = false;

        try{
            classroomMapper.insertClassroom(classroom);
        }catch (Exception e){

        }
    }

    @Override
    public boolean deleteClassroomById(Integer id) {
        return false;
    }

    @Override
    public boolean updateClassroom(Classroom classroom) {
        return false;
    }

    @Override
    public List<Classroom> findAllClassroom() {
        return null;
    }

    @Override
    public Classroom findClassroomById(Integer id) {
        return null;
    }
}
