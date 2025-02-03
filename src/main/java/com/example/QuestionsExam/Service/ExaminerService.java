package com.example.QuestionsExam.Service;

import com.example.QuestionsExam.Model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
