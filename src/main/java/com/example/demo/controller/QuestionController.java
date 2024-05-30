package com.example.demo.controller;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.QuestionService;
import com.example.demo.validation.AnswerForm;
import com.example.demo.validation.QuestionForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.engine.jdbc.mutation.spi.BindingGroup;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page" , defaultValue = "0")int page){
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging",paging);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id, AnswerForm answerForm){
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question",question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String createQuestion(QuestionForm questionForm){
        return "question_form";
    }
    @PostMapping("/create")
    public String createQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "question_form";
        }
        this.questionService.createQuestion(questionForm.getSubject(),questionForm.getContent());
        return "redirect:/";
    }
}
