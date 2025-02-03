package com.example.QuestionsExam.Controller;

import com.example.QuestionsExam.Model.Question;
import com.example.QuestionsExam.Service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController//Смысл контроллера принять запрос и передать
@RequestMapping("/exam/java")
public class JavaQuestionController {

    @PostConstruct
    public void setQuestionService() {
        add("Какие виды памяти", "Стек и Куча");
        add("Сколько принципов ООП", "3");
        add("Какие принципы ООП", "Инкапсуляция, Полиморфизм, Наследование");
    }

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    // по GET запросу exam/java мы получим список всех вопрссов
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    //Добавить вопрос
    @GetMapping(path = "/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    //Удалить вопрос
    @GetMapping(path = "/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }
}
