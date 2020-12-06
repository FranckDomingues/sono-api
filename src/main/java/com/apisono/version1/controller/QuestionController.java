package com.apisono.version1.controller;

import com.apisono.version1.model.Question;
//import com.apisono.version1.model.QuestionResultHistoric;
import com.apisono.version1.model.dtos.QuestionCreateDTO;
import com.apisono.version1.repository.QuestionRepository;
import com.apisono.version1.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {
    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionController(QuestionRepository questionRepository, UserRepository userRepository){
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }
    @GetMapping
        public ResponseEntity<Iterable<Question>> getQuestions() {
            return ResponseEntity.ok(questionRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionCreateDTO questionCreateDTO){
        Question question=questionRepository.save(Question.builder()
                .date(questionCreateDTO.getDate())
                .score(questionCreateDTO.getScore())
                .user(userRepository.findById(questionCreateDTO.getUserId()).get())
                .build());

        if(question!=null){
            return ResponseEntity.ok(question);
        }
        return ResponseEntity.badRequest().build();
    }

}