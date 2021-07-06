package com.example.project

import java.util.List

public class StudentGradeCalculator {

    public IStudentDatabase studentDatabase

    public StudentGradeCalculator(IStudentDatabase studentDatabase) {

        this.studentDatabase = studentDatabase
    }

    public String calculateStudentGrade(String studentId) {

        String grade

        grade = studentDatabase.getStudentGrade(studentId)
        if(grade != null && !grade.isEmpty()) {

            return grade
        }

        List<Float> scoreList = studentDatabase.getStudentScores(studentId)

        Float totalScore = 0F

        if(scoreList != null)
            totalScore = scoreList.stream().reduce(Identity: 0F, (a, b) -> a + b)

        if(totalScore > 90) {
            grade = "A"
        } else if (totalScore > 80) {
            grade = "B"
        } else {
            grade = "C"
        }

        // update the calculated grade in database
        studentDatabase.updateStudentGrade(studentId, grade)

        return grade
    }
}