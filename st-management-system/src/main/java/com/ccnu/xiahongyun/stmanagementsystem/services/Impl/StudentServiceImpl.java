package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.Utils.InUtils.TokenDetail;
import com.ccnu.xiahongyun.stmanagementsystem.Utils.TokenUtils;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentExamroominfoMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Student;
import com.ccnu.xiahongyun.stmanagementsystem.model.StudentExpand;
import com.ccnu.xiahongyun.stmanagementsystem.query.StudentQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentMapper studentMapper;
    private final StudentExamroominfoMapper studentExamroominfoMapper;
    private final TokenUtils tokenUtils;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper, StudentExamroominfoMapper studentExamroominfoMapper, TokenUtils tokenUtils) {
        this.studentMapper = studentMapper;
        this.studentExamroominfoMapper = studentExamroominfoMapper;
        this.tokenUtils = tokenUtils;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean insertStudent(Student student) {
        Boolean isSuccess;
        try{
            if(student.getId() == null || student.getSubjectid() == null){
                return false;
            }

            if(studentMapper.findSidBysId(student.getId()).size() == 0 || studentMapper.findSidBysId(student.getId()).get(0) == null){
                student.setSid(tokenUtils.getSid());
            }
            else{
                student.setSid(studentMapper.findSidBysId(student.getId()).get(0));
            }
            studentMapper.insertStudent(student);
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean updateStudent(Student student) {
        Boolean isSuccess;
        try{
            studentMapper.updateStudent(student);
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public boolean deleteStudent(Student student) {
        Boolean isSuccess;
        try{
            if(student.getSid() == null || student.getSubjectid() == null){
                return false;
            }
            studentMapper.deleteStudent(student.getSid());
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<StudentExpand> selectStudentByStudentQuery(StudentQuery studentQuery) {

        List<Student> studentList;
        List<StudentExpand> studentExpandList = new ArrayList<>();
        try{
            studentList = studentMapper.findStudentByLimit(studentQuery);
            for (Student student: studentList) {
                StudentExpand studentExpand = new StudentExpand(student);
                Integer examroomid = studentExamroominfoMapper.findStudentExamroomById(student.getSid(), student.getSubjectid());
                if(examroomid != null) {
                    studentExpand.setExamroomid(examroomid);
                }
                studentExpandList.add(studentExpand);
            }
            return studentExpandList;
        }catch (Exception e){
            studentExpandList.clear();
        }
        return studentExpandList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer countStudentByStudentQuery(StudentQuery studentQuery) {
        Integer count;

        try{
            count = studentMapper.findStudentCount(studentQuery);
        }catch (Exception e){
            count = 0;
        }
        return count;
    }
}
