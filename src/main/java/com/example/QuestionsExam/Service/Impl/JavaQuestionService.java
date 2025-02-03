package com.example.QuestionsExam.Service.Impl;

import com.example.QuestionsExam.Model.Question;
import com.example.QuestionsExam.Service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    //Хранит наши вопросы
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();//Заводим обьект типа Random

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        boolean isRemove = questions.remove(question);
        if (isRemove) {
            return question;
        } else {
            return null;
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);//Мы возвращаем новую копию не изменяемых данных
        //если мы вернем просто question, то дадим полным доступ к оригиналу и нарушаем инкапсуляцию.
    }

    @Override
    public Question getRandomQuestion() {
        int randomIndex = random.nextInt(questions.size());// получили случайное чило от 0 до количества элементов
        return new ArrayList<>(questions).get(randomIndex);
    }
}
