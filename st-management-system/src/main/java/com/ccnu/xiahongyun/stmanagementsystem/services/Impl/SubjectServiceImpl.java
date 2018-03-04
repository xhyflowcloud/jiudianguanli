package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.SubjectMapper;
import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.services.SubjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

    private final SubjectMapper subjectMapper;

    public SubjectServiceImpl(SubjectMapper subjectMapper){
        this.subjectMapper = subjectMapper;
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
}
