package com.example.QuestionsExam.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotEnoughQuestionExeption extends RuntimeException {
    public NotEnoughQuestionExeption() {
    }

    public NotEnoughQuestionExeption(String message) {
        super(message);
    }

    public NotEnoughQuestionExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughQuestionExeption(Throwable cause) {
        super(cause);
    }

    public NotEnoughQuestionExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
