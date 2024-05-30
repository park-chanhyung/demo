package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private QuestionService questionService;
    
    @Test
    void testJpa() {
        for (int i = 0; i < 300; i++) {
            String subject =String.format("테스트 데이터 입니다 : [%03d] ",i);
            String content = "테스트 데이터 입니다";

            this.questionService.createQuestion(subject,content);
            
        }
    }


}
