package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;

import java.util.List;

public interface ClassroomService {

    boolean insertClassroom(Classroom classroom);
    boolean deleteClassroomById(Integer id);
    boolean updateClassroom(Classroom classroom);
    List<Classroom> findClassroomByClassroomQuery(ClassroomQuery classroomQuery);
    Integer findClassroomCountByClassroomQuery(ClassroomQuery classroomQuery);
}
