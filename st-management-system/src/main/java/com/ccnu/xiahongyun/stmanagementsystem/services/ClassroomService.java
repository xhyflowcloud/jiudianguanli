package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;

import java.util.List;

public interface ClassroomService {

    boolean insertClassroom(Classroom classroom);
    boolean deleteClassroomById(Integer id);
    boolean updateClassroom(Classroom classroom);
    List<Classroom> findAllClassroom();
    Classroom findClassroomById(Integer id);
}
