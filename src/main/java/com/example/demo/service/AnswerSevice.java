package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;
import com.example.demo.entity.SiteUser;
import com.example.demo.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerSevice {

    private final AnswerRepository answerRepository;
//    public Answer getAnswer(Integer id) {
//        Optional<Answer> answer = this.answerRepository.findById(id);
//        if (answer.isPresent()) {
//            return answer.get();
//        } else {
//            throw new DataNotFoundException("answer not found");
//        }
//    }
//
//    public void modify(Answer answer, String content) {
//        answer.setContent(content);
//        answer.setModifyDate(LocalDateTime.now());
//        this.answerRepository.save(answer);
//    }
    public void create(Question question, String content, SiteUser author){
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author);
        this.answerRepository.save(answer);
    }
    public Answer getAnswer(Long id){
        Optional<Answer> answer = this.answerRepository.findById(id);
        if(answer.isPresent()){
            return answer.get();
        }else {
            throw new DataNotFoundException("answer not found");
        }
    }
    public void modify(Answer answer,String content){
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
    public void delete(Answer answer){
        this.answerRepository.delete(answer);
    }
}
