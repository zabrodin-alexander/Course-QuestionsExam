package com.example.QuestionsExam.Service;

import com.example.QuestionsExam.Model.Question;

import java.util.Collection;

//Интерфейс это поведение (контракт), что будет реализовывать класс
public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
