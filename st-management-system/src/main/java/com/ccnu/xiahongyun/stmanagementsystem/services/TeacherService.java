package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Teacher;
import com.ccnu.xiahongyun.stmanagementsystem.query.TeacherQuery;

import java.util.List;

public interface TeacherService {
    boolean insertTeacher(Teacher teacher);
    boolean deleteTeacherById(Integer id);
    boolean updateTeacher(Teacher teacher);
    List<Teacher> findTeacherByTeacherQuery(TeacherQuery TeacherQuery);
    Integer findTeacherCountByTeacherQuery(TeacherQuery TeacherQuery);
}
