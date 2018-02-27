package com.ccnu.xiahongyun.stmanagementsystem.query;

import com.ccnu.xiahongyun.stmanagementsystem.model.Classroom;
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
        return  sql.toString();
    }


    public String selectExamroom(ClassroomQuery classroom){
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

        return  sql.toString();
    }

    public String selectStudent(StudentQuery student){
        StringBuffer sql = new StringBuffer("select * from  student where 1=1");
        if(student.getExamid()!=null){
            sql.append(" and examid = #{examid}");
        }
        if(student.getName()!=null){
            sql.append("and name=#{name}");
        }
        if(student.getId()!=null){
            sql.append("and id=#{id}");
        }
        if(student.getSid()!=null){
            sql.append("and sid=#{sid}");
        }

        Integer temp = (student.getPageIndex()-1)*student.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectStudentCount(StudentQuery student){
        StringBuffer sql = new StringBuffer("select count(*) from student where 1=1");
        if(student.getExamid()!=null){
            sql.append(" and examid = #{examid}");
        }
        if(student.getName()!=null){
            sql.append("and name=#{name}");
        }
        if(student.getId()!=null){
            sql.append("and id=#{id}");
        }
        if(student.getSid()!=null){
            sql.append("and sid=#{sid}");
        }
        return  sql.toString();
    }
    public String selectSubject(ClassroomQuery classroom){
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

        return  sql.toString();
    }

    public String selectTeacher(TeacherQuery teacher){
        StringBuffer sql = new StringBuffer("select * from  teacher where 1=1");
        if(teacher.getId()!=null){
            sql.append(" and id = #{id}");
        }
        if(teacher.getName()!=null){
            sql.append(" and name = #{name}");
        }
        if(teacher.getInvigilator()!=null){
            sql.append("and isInvigilator = #{isInvigilator}");
        }
        if(teacher.getNumInvigilator()!=null){
            sql.append("and numInvigilator = #{numInvigilator}");
        }
        if(teacher.getAccInvigilator()!=null){
            sql.append("and accInvigilator  = #{accInvigilator}");
        }

        Integer temp = (teacher.getPageIndex()-1)*teacher.getPageSize();
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectTeacherCount(TeacherQuery teacher){
        StringBuffer sql = new StringBuffer("select count(*) from teacher where 1=1");
        if(teacher.getId()!=null){
            sql.append(" and id = #{id}");
        }
        if(teacher.getName()!=null){
            sql.append(" and name = #{name}");
        }
        if(teacher.getInvigilator()!=null){
            sql.append("and isInvigilator = #{isInvigilator}");
        }
        if(teacher.getNumInvigilator()!=null){
            sql.append("and numInvigilator = #{numInvigilator}");
        }
        if(teacher.getAccInvigilator()!=null){
            sql.append("and accInvigilator  = #{accInvigilator}");
        }
        return  sql.toString();
    }


}
