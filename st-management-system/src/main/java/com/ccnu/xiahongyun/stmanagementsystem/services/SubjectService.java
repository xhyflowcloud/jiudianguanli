package com.ccnu.xiahongyun.stmanagementsystem.services;

import com.ccnu.xiahongyun.stmanagementsystem.model.Examroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.model.SubjectString;
import com.ccnu.xiahongyun.stmanagementsystem.model.SubjectTest;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects();
    Boolean insertSubject(SubjectTest subjectTest);
    Boolean deleteSubject(SubjectTest subjectTest);
    List<SubjectString> findSubjectBySubjectQuery(SubjectQuery subjectQuery);
    Integer countSubjectBySubjectQuery(SubjectQuery subjectQuery);
    Boolean assignExamroom(Examroom examroom);
}
