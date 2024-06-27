package com.example.demo.controller;

import com.example.demo.dao.QuestionDao;
import com.example.demo.model.Question;
import com.example.demo.security.IsAdmin;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    QuestionDao questionDao;

    @IsAdmin
    @PostMapping("/question")
    public ResponseEntity<Question> add(@RequestBody @Valid Question question) {
        question.setId(null);
        questionDao.save(question);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }


}
