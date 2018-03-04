package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.model.StudentExpand;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;

import java.util.List;

public interface StudentService {

    boolean insertStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
    List<StudentExpand> selectStudentByStudentQuery(StudentQuery studentQuery);
    Integer countStudentByStudentQuery(StudentQuery studentQuery);
}
