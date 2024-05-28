package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.service.AnswerSevice;
import com.example.demo.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerSevice answerSevice;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Long id, @RequestParam(value = "content")
                               String content)
    {
        Question question = this.questionService.getQuestion(id);
        this.answerSevice.create(question,content);
        return String.format("redirect:/question/detail/%s",id);
    }
}
