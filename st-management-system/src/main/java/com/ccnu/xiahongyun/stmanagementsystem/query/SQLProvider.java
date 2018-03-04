package com.ccnu.xiahongyun.stmanagementsystem.query;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
import com.ccnu.xiahongyun.stmanagementsystem.model.Subject;
import com.ccnu.xiahongyun.stmanagementsystem.query.ClassroomQuery;
import org.apache.commons.lang.StringUtils;

public class SQLProvider {

    public String selectClassroom(ClassroomQuery classroom){
        StringBuffer sql = new StringBuffer("select * from  classroom where 1=1");
        if(classroom.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(classroom.getSize() != null){
            sql.append(" and size = #{size}");
        }
        if(classroom.getPosition() != null && StringUtils.isNotEmpty(classroom.getPosition())){
            sql.append(" and position = #{position}");
        }
        if(classroom.getEnable() != null){
            sql.append(" and isEnable = #{isEnable}");
        }
        if(classroom.getStarttime() != null){
            sql.append(" and starttime = #{starttime}");
        }
        if(classroom.getEndtime() != null){
            sql.append(" and endtime = #{endtime}");
        }
        Integer temp = (classroom.getPageIndex()-1)*classroom.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectClassroomCount(ClassroomQuery classroom){
        StringBuffer sql = new StringBuffer("select count(*) from  classroom where 1=1");
        if(classroom.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(classroom.getSize() != null){
            sql.append(" and size = #{size}");
        }
        if(classroom.getPosition() != null && StringUtils.isNotEmpty(classroom.getPosition())){
            sql.append(" and position = #{position}");
        }
        if(classroom.getEnable() != null){
            sql.append(" and isEnable = #{isEnable}");
        }
        if(classroom.getStarttime() != null){
            sql.append(" and starttime = #{starttime}");
        }
        if(classroom.getEndtime() != null){
            sql.append(" and endtime = #{endtime}");
        }
        return  sql.toString();
    }

    public String selectStudent(StudentQuery student){
        StringBuffer sql = new StringBuffer("select * from  student where 1=1");
        if(student.getSid() != null){
            sql.append(" and sid = #{sid}");
        }
        if(student.getId() != null && StringUtils.isNotEmpty(student.getId())){
            sql.append(" and id = #{id}");
        }
        if(student.getName() != null && StringUtils.isNotEmpty(student.getName())){
            sql.append(" and name = #{name}");
        }
        if(student.getSubjectid() != null){
            sql.append(" and subjectid = #{subjectid}");
        }
        Integer temp = (student.getPageIndex()-1)*student.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectStudentCount(StudentQuery student){
        StringBuffer sql = new StringBuffer("select count(*) from  student where 1=1");
        if(student.getSid() != null){
            sql.append(" and sid = #{sid}");
        }
        if(student.getId() != null && StringUtils.isNotEmpty(student.getId())){
            sql.append(" and id = #{id}");
        }
        if(student.getName() != null && StringUtils.isNotEmpty(student.getName())){
            sql.append(" and name = #{name}");
        }
        if(student.getSubjectid() != null){
            sql.append(" and subjectid = #{subjectid}");
        }
        return  sql.toString();
    }

    public String selectSubject(SubjectQuery subject){
        StringBuffer sql = new StringBuffer("select * from  subject where 1=1");
        if(subject.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(subject.getName() != null && StringUtils.isNotEmpty(subject.getName())){
            sql.append(" and name = #{id}");
        }
        if(subject.getStarttime()!= null){
            sql.append(" and starttime = #{starttime}");
        }
        if(subject.getEndtime()!= null){
            sql.append(" and endtime = #{endtime}");
        }
        if(subject.getBmstarttime()!= null){
            sql.append(" and bmstarttime = #{bmstarttime}");
        }
        if(subject.getBmendtime()!= null){
            sql.append(" and bmendtime = #{bmendtime}");
        }
        if(subject.getMaxnumber()!= null){
            sql.append(" and maxnumber = #{maxnumber}");
        }
        if(subject.getMinnumber()!= null){
            sql.append(" and minnumber = #{number}");
        }

        Integer temp = (subject.getPageIndex()-1)*subject.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectSubjectCount(SubjectQuery subject){
        StringBuffer sql = new StringBuffer("select count(*) from  subject where 1=1");
        if(subject.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(subject.getName() != null && StringUtils.isNotEmpty(subject.getName())){
            sql.append(" and name = #{id}");
        }
        if(subject.getStarttime()!= null){
            sql.append(" and starttime = #{starttime}");
        }
        if(subject.getEndtime()!= null){
            sql.append(" and endtime = #{endtime}");
        }
        if(subject.getBmstarttime()!= null){
            sql.append(" and bmstarttime = #{bmstarttime}");
        }
        if(subject.getBmendtime()!= null){
            sql.append(" and bmendtime = #{bmendtime}");
        }
        if(subject.getMaxnumber()!= null){
            sql.append(" and maxnumber = #{maxnumber}");
        }
        if(subject.getMinnumber()!= null){
            sql.append(" and minnumber = #{number}");
        }
        return  sql.toString();
    }

    public String selectTeacher(TeacherQuery teacher){
        StringBuffer sql = new StringBuffer("select * from  teacher where 1=1");
        if(teacher.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(teacher.getName() != null && StringUtils.isNotEmpty(teacher.getName())){
            sql.append(" and name = #{name}");
        }

        if(teacher.getStarttime()!= null){
            sql.append(" and starttime = #{starttime}");
        }
        if(teacher.getEndtime() != null){
            sql.append(" and endtime = #{endtime}");
        }

        if(teacher.getInvigilator() != null){
            sql.append(" and isInvigilator = #{isInvigilator}");
        }
        if(teacher.getAccInvigilator() != null){
            sql.append(" and accInvigilator = #{accInvigilator}");
        }
        if(teacher.getNumInvigilator() != null){
            sql.append(" and numInvigilator = #{numInvigilator}");
        }
        Integer temp = (teacher.getPageIndex()-1)*teacher.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectTeacherCount(TeacherQuery teacher){
        StringBuffer sql = new StringBuffer("select count(*) from  teacher where 1=1");
        if(teacher.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(teacher.getName() != null && StringUtils.isNotEmpty(teacher.getName())){
            sql.append(" and name = #{name}");
        }

        if(teacher.getStarttime()!= null){
            sql.append(" and starttime = #{starttime}");
        }
        if(teacher.getEndtime() != null){
            sql.append(" and endtime = #{endtime}");
        }

        if(teacher.getInvigilator() != null){
            sql.append(" and isInvigilator = #{isInvigilator}");
        }
        if(teacher.getAccInvigilator() != null){
            sql.append(" and accInvigilator = #{accInvigilator}");
        }
        if(teacher.getNumInvigilator() != null){
            sql.append(" and numInvigilator = #{numInvigilator}");
        }
        return  sql.toString();
    }






















    public String selectExamroom(ExamroomQuery examroom){
        StringBuffer sql = new StringBuffer("select * from  examroom where 1=1");
        if(examroom.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(examroom.getRid() != null){
            sql.append(" and rid = #{rid}");
        }
        if(examroom.getSid() != null){
            sql.append(" and sid = #{sid}");
        }
        if(examroom.getTid() != null){
            sql.append(" and tid = #{tid}");
        }
        if(examroom.getNumber() != null){
            sql.append(" and number = #{number}");
        }
        Integer temp = (examroom.getPageIndex()-1)*examroom.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectExamroomCount(ExamroomQuery examroom){
        StringBuffer sql = new StringBuffer("select count(*) from  examroom where 1=1");
        if(examroom.getId() != null){
            sql.append(" and id = #{id}");
        }
        if(examroom.getRid() != null){
            sql.append(" and rid = #{rid}");
        }
        if(examroom.getSid() != null){
            sql.append(" and sid = #{sid}");
        }
        if(examroom.getTid() != null){
            sql.append(" and tid = #{tid}");
        }
        if(examroom.getNumber() != null){
            sql.append(" and number = #{number}");
        }
        return  sql.toString();
    }










}
