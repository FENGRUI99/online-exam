package com.fengrui.pojo;

import java.util.Date;

public class ExamStudentMedia {
    Integer id;
    Integer userId;
    Integer classId;
    Integer examId;
    String examName;
    Integer score;
    Integer totalScore;
    Date time;
    User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ExamStudentMedia{" +
                "id=" + id +
                ", userId=" + userId +
                ", classId=" + classId +
                ", examId=" + examId +
                ", examName='" + examName + '\'' +
                ", score=" + score +
                ", totalScore=" + totalScore +
                ", time=" + time +
                '}';
    }
}
