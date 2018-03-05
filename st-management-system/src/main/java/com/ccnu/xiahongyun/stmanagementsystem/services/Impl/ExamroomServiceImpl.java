package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.ExamroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentExamroominfoMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Examroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.query.ExamroomQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.ExamroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamroomServiceImpl implements ExamroomService{
    private final StudentMapper studentMapper;
    private final ExamroomMapper examroomMapper;
    private final StudentExamroominfoMapper studentExamroominfoMapper;

    @Autowired
    public ExamroomServiceImpl(StudentMapper studentMapper, ExamroomMapper examroomMapper, StudentExamroominfoMapper studentExamroominfoMapper) {
        this.studentMapper = studentMapper;
        this.examroomMapper = examroomMapper;
        this.studentExamroominfoMapper = studentExamroominfoMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Examroom> findExamroomByQuery(ExamroomQuery examroomQuery) {

        List<Examroom> examrooms;
        try{
            examrooms = examroomMapper.findExamroomByLimit(examroomQuery);
        }catch (Exception e){
            examrooms = new ArrayList<>();
        }
        return examrooms;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer countExamroomByQuery(ExamroomQuery examroomQuery) {
        Integer count;
        try{
            count = examroomMapper.findExamroomCount(examroomQuery);
        }catch (Exception e){
            count = 0;
        }
        return count;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Student> findStudentByExamroomId(Integer examroomid) {
        List<Student> students = new ArrayList<>();
        List<Integer> studentids;
        try {
            studentids = studentExamroominfoMapper.findStudentByExamroomId(examroomid);
            for (Integer studentid: studentids){
                Student student = studentMapper.findStudentBysId(studentid);
                students.add(student);
            }
        }catch (Exception e){
            students.clear();
        }
        return students;
    }
}
