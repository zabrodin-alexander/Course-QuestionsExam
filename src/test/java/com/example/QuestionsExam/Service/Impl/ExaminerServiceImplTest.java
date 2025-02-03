package com.example.QuestionsExam.Service.Impl;

import com.example.QuestionsExam.Exeption.NotEnoughQuestionExeption;
import com.example.QuestionsExam.Model.Question;
import com.example.QuestionsExam.Service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        int amount = 3;
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            questions.add(new Question("question" + i, "answer" + i));
        }
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0), questions.get(0),
                questions.get(1), questions.get(1),
                questions.get(1), questions.get(2)
        );
        Collection<Question> actualQuestion = examinerService.getQuestions(amount);
        assertEquals(actualQuestion.size(), amount);
        assertTrue(actualQuestion.containsAll(questions));
        verify(questionService, times(6)).getRandomQuestion();
    }

    @Test
    public void throwExeptionQuestion() {
        int amount = 3;
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount / 2; i++) {
            questions.add(new Question("question" + i, "answer" + i));
        }
        when(questionService.getAll()).thenReturn(questions);
        assertThrows(
                NotEnoughQuestionExeption.class,
                () -> examinerService.getQuestions(amount)
        );
    }
}
