package com.ccnu.xiahongyun.stmanagementsystem.model;

public class StudentExpand {
    String name;

    /**
     * 身份证号
     */
    String id;

    /**
     * 报名ID
     */
    Integer sid;

    Integer subjectid;

    Integer examroomid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Integer getExamroomid() {
        return examroomid;
    }

    public void setExamroomid(Integer examroomid) {
        this.examroomid = examroomid;
    }
}
