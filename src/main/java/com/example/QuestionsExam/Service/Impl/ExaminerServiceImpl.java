package com.example.QuestionsExam.Service.Impl;

import com.example.QuestionsExam.Exeption.NotEnoughQuestionExeption;
import com.example.QuestionsExam.Model.Question;
import com.example.QuestionsExam.Service.ExaminerService;

import com.example.QuestionsExam.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    //ExaminerServiceImpl не хрнати никаких вопросв, поэтому мы привязываем QuestionService
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        //Если количество запрошенных вопросов больше чем в нашей базе вопросов, то выкидываем исключение
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionExeption("Превышено количество вопросов");
        }
        Set<Question> randomQuestion = new HashSet<>();
        //Пока размер Set меньше количества(amount) мы добавляем рандомный вопрос
        while (randomQuestion.size() < amount) {
            randomQuestion.add(questionService.getRandomQuestion());
        }
        return randomQuestion;
    }


}


