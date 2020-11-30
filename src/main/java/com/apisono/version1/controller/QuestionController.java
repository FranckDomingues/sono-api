package com.apisono.version1.controller;

import com.apisono.version1.model.Questions;
import com.apisono.version1.model.QuestionResults;
//import com.apisono.version1.model.QuestionResultHistoric;
import com.apisono.version1.model.User;
import com.apisono.version1.model.dtos.QuestionCreateDTO;
import com.apisono.version1.repository.QuestionRepository;
import com.apisono.version1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionController(QuestionRepository questionRepository, UserRepository userRepository){
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }
  @RequestMapping
        public ResponseEntity<Iterable<Questions>> getQuestions() {

  }

}
