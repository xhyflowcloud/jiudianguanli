package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.ExamroomMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.StudentMapper;
import com.ccnu.xiahongyun.stmanagementsystem.mapper.SubjectMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.model.SubjectString;
import com.ccnu.xiahongyun.stmanagementsystem.model.SubjectTest;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectMapper subjectMapper;
    private final StudentMapper studentMapper;
    private final ExamroomMapper examroomMapper;

    public SubjectServiceImpl(SubjectMapper subjectMapper, StudentMapper studentMapper, ExamroomMapper examroomMapper){
        this.subjectMapper = subjectMapper;
        this.studentMapper = studentMapper;
        this.examroomMapper = examroomMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<Subject> findAllSubjects() {
        List<Subject> subjectList;
        List<Subject> subjects = new ArrayList<>();
        try{
            subjectList = subjectMapper.selectAllSubject();
            for (Subject subject: subjectList){
                /*if(subject.getBmendtime()== null || subject.getBmstarttime()==null || subject.getBmendtime() < new Date().getTime() || subject.getBmstarttime() > new Date().getTime()){
                    continue;
                }
                else{
                    subjects.add(subject);
                }*/
                subjects.add(subject);
            }
        }catch (Exception e){
            subjects.clear();
        }
        return subjects;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean insertSubject(SubjectTest subjectTest) {
        Boolean isSuccess;
        try{
            if(subjectTest.getBmendtime() == null || subjectTest.getBmstarttime() == null || subjectTest.getStarttime() == null ||
                    subjectTest.getEndtime() == null || subjectTest.getMaxnumber() == null){
                return false;
            }
            Subject subject = new Subject();
            subject.setName(subjectTest.getName());
            subject.setBmstarttime(subjectTest.getBmstarttime().getTime());
            subject.setBmendtime(subjectTest.getBmendtime().getTime());
            subject.setStarttime(subjectTest.getStarttime().getTime());
            subject.setEndtime(subjectTest.getEndtime().getTime());
            subject.setMaxnumber(subjectTest.getMaxnumber());
            subject.setMinnumber(0);

            subjectMapper.insertSubject(subject);
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean deleteSubject(SubjectTest subjectTest) {
        Boolean isSuccess;
        List<Integer> studentids;
        try {
            if(subjectTest.getId() == null){
                return false;
            }
            studentids = studentMapper.findSidBySubjectId(subjectTest.getId());
            if(studentids.size() == 0){
                examroomMapper.deleteExamroomBySubjectId(subjectTest.getId());
                subjectMapper.deleteSubject(subjectTest.getId());
                isSuccess = true;
            }else{
                isSuccess = false;
            }
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public List<SubjectString> findSubjectBySubjectQuery(SubjectQuery subjectQuery) {
        List<Subject> subjectList;
        List<SubjectString> subjectTestList = new ArrayList<>();

        try{
            subjectList = subjectMapper.findSubjectByLimit(subjectQuery);
            for (Subject subject: subjectList){
                SubjectString subjectTest = new SubjectString();
                subjectTest.setId(subject.getId());
                subjectTest.setName(subject.getName());
                subjectTest.setBmstarttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(subject.getBmstarttime())));
                subjectTest.setBmendtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(subject.getBmendtime())));
                subjectTest.setStarttime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(subject.getStarttime())));
                subjectTest.setEndtime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(subject.getEndtime())));
                subjectTest.setMaxnumber(subject.getMaxnumber());
                subjectTest.setMinnumber(subject.getMinnumber());
                subjectTestList.add(subjectTest);
            }
        }catch (Exception e){
            subjectTestList.clear();
        }
        return subjectTestList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Integer countSubjectBySubjectQuery(SubjectQuery subjectQuery) {
        Integer count;

        try{
            count = subjectMapper.findSubjectCount(subjectQuery);
        }catch (Exception e){
            count = 0;
        }
        return count;
    }
}
