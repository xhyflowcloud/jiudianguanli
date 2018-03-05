package com.ccnu.xiahongyun.stmanagementsystem.services.Impl;

import com.ccnu.xiahongyun.stmanagementsystem.mapper.*;
import com.ccnu.xiahongyun.stmanagementsystem.model.*;
import com.ccnu.xiahongyun.stmanagementsystem.query.SubjectQuery;
import com.ccnu.xiahongyun.stmanagementsystem.services.StudentService;
import com.ccnu.xiahongyun.stmanagementsystem.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final TeacherMapper teacherMapper;
    private final ClassroomMapper classroomMapper;
    private final StudentExamroominfoMapper studentExamroominfoMapper;
    private final StudentService studentService;

    @Autowired
    public SubjectServiceImpl(SubjectMapper subjectMapper, StudentMapper studentMapper, ExamroomMapper examroomMapper, TeacherMapper teacherMapper, ClassroomMapper classroomMapper, StudentExamroominfoMapper studentExamroominfoMapper, StudentService studentService){
        this.subjectMapper = subjectMapper;
        this.studentMapper = studentMapper;
        this.examroomMapper = examroomMapper;
        this.teacherMapper = teacherMapper;
        this.classroomMapper = classroomMapper;
        this.studentExamroominfoMapper = studentExamroominfoMapper;
        this.studentService = studentService;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public Boolean assignExamroom(Examroom examroom) {

        Boolean isSuccess;
        Subject subject;
        List<Teacher> teachers;
        List<Classroom> classrooms;
        List<Student> students;
        Classroom classroom;
        Teacher teacher;
        try{
            subject = subjectMapper.selectSubjectById(examroom.getSid());
            teachers =teacherMapper.selectAllTeacher();
            classrooms = classroomMapper.selectAllClassroom();
            students = studentMapper.selectStudentNoExamroom(examroom.getSid());
            if(students.size() == 0){
                return false;
            }
            for(int i = 0; i < students.size(); i++){
                if(i % examroom.getNumber() == 0) {
                    classroom = selectClassroom(subject, classrooms);
                    if (classroom == null) {
                        throw new Exception();
                    }
                    classroomMapper.updateClassroom(classroom);
                    teacher = selectTeacher(subject, teachers);
                    if (teacher == null) {
                        throw new Exception();
                    }
                    teacherMapper.updateTeacher(teacher);
                    examroom.setRid(classroom.getId());
                    examroom.setTid(teacher.getId());
                    examroomMapper.insertExamroom(examroom);
                }

                Integer examroomid = examroomMapper.findIdBySubAndTea(examroom.getSid(), examroom.getTid());
                studentExamroominfoMapper.insertStudentExamroomInfo(examroomid, students.get(i).getSid(), examroom.getSid());
            }
            isSuccess = true;
        }catch (Exception e){
            isSuccess = false;
        }
        return isSuccess;
    }

    private Classroom selectClassroom(Subject subject, List<Classroom> classrooms){
        Classroom classroom = null;

        try {
            for(Classroom classroom1: classrooms){
                if(classroom1.getEnable() && (subject.getStarttime() > classroom1.getEndtime() || subject.getEndtime() < classroom1.getStarttime())){
                    if(classroom != null && classroom.getSize() > classroom1.getSize()){
                        classroom = classroom1;
                    }else{
                        classroom = classroom1;
                    }
                }
            }
        }catch (Exception e){
            classroom = null;
        }
        return classroom;
    }

    private Teacher selectTeacher(Subject subject, List<Teacher> teachers){
        Teacher teacher = null;
        try{
            for(Teacher teacher1: teachers){
                if(subject.getStarttime() > teacher1.getEndtime() || subject.getEndtime() < teacher1.getStarttime()){
                    if(teacher != null){
                        if(teacher.getInvigilator() && !teacher.getAccInvigilator() && teacher1.getInvigilator() && !teacher1.getAccInvigilator() && teacher.getNumInvigilator() < teacher1.getNumInvigilator()){
                            teacher = teacher1;
                        }
                        else if(teacher.getAccInvigilator() && teacher1.getInvigilator() && (!teacher1.getAccInvigilator() || teacher.getNumInvigilator() < teacher1.getNumInvigilator())){
                            teacher = teacher1;
                        }
                    }else{
                        teacher = teacher1;
                    }
                }
            }

        }catch (Exception e){
            teacher = null;
        }
        return teacher;
    }
}
