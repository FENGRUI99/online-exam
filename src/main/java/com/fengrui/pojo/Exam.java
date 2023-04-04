package com.fengrui.pojo;

import java.util.Date;

public class Exam {
    Integer id;
    String examName;
    Integer courseId;
    Integer teaUserId;
    Integer classId;
    Integer questionNumber;
    String singleScore;
    Date startTime;
    Date endTime;
    Integer during;
    Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeaUserId() {
        return teaUserId;
    }

    public void setTeaUserId(Integer teaUserId) {
        this.teaUserId = teaUserId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(String singleScore) {
        this.singleScore = singleScore;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuring() {
        return during;
    }

    public void setDuring(Integer during) {
        this.during = during;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "exam{" +
                "id=" + id +
                ", examName='" + examName + '\'' +
                ", courseId=" + courseId +
                ", teaUserId=" + teaUserId +
                ", classId=" + classId +
                ", questionNumber=" + questionNumber +
                ", singleScore='" + singleScore + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", during=" + during +
                '}';
    }
}
