package com.example.project

import java.util.List

public interface IStudentDatabase {

    List<Float> getStudentScores(String studentId)
    
    void updateStudentGrade(String studentId, String grade)

    String getStudentGrade(String studentId)
}