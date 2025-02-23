package com.example.QuestionsExam.Service.Impl;

import com.example.QuestionsExam.Model.Question;
import com.example.QuestionsExam.Service.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @Test
    void add() {
        Question expectedQuestion = new Question("Boolean это примитивный тип данных", "Нет");
        Question actualQuestion = questionService.add(expectedQuestion);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void remove() {
        Question expectedQuestion = new Question("Boolean это примитивный тип данных", "Нет");
        questionService.add(expectedQuestion);
        Question actualQuestion = questionService.remove(expectedQuestion);
        assertEquals(expectedQuestion, actualQuestion);
    }

    @Test
    void getAll() {
        Question question1 = new Question("Boolean - это примитивный тип данных", "Нет");
        Question question2 = new Question("Long - это примитивный тип данных", "Да");
        questionService.add(question1);
        questionService.add(question2);
        Set<Question> expectedQuestion = new HashSet<>() {{
            add(question1);
            add(question2);
        }};
        Collection<Question> actuallQuestion = questionService.getAll();
        assertEquals(expectedQuestion, actuallQuestion);
    }

    @Test
    void getRandomQuestion() {
        Question question1 = new Question("Boolean - это примитивный тип данных", "Нет");
        Question question2 = new Question("Long - это примитивный тип данных", "Да");
        questionService.add(question1);
        questionService.add(question2);
        Set<Question> question = new HashSet<>() {{
            add(question1);
            add(question2);
        }};
        Question randomQuestion = questionService.getRandomQuestion();
        assertTrue(question.contains(randomQuestion));
    }
}
