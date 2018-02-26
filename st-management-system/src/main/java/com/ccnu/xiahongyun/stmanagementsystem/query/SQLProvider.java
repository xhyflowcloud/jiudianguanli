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
        Integer temp = (classroom.pageIndex-1)*classroom.pageSize;
        sql.append(" LIMIT "+temp+", #{pageSize}");
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
        Integer temp = (classroom.pageIndex-1)*classroom.pageSize;
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectStudent(ClassroomQuery classroom){
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
        Integer temp = (classroom.pageIndex-1)*classroom.pageSize;
        sql.append(" LIMIT "+temp+", #{pageSize}");
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
        Integer temp = (classroom.pageIndex-1)*classroom.pageSize;
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

    public String selectTeacher(ClassroomQuery classroom){
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
        Integer temp = (classroom.pageIndex-1)*classroom.pageSize;
        sql.append(" LIMIT "+temp+", #{pageSize}");
        return  sql.toString();
    }

}
