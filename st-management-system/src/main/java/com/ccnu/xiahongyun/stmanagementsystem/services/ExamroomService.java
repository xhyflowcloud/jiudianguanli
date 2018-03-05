package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Examroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.query.ExamroomQuery;

import java.util.List;

public interface ExamroomService {
    List<Examroom> findExamroomByQuery(ExamroomQuery examroomQuery);
    Integer countExamroomByQuery(ExamroomQuery examroomQuery);
    List<Student> findStudentByExamroomId(Integer examroomid);
}
