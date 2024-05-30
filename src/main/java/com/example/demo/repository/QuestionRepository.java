package com.example.demo.repository;

import com.example.demo.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface QuestionRepository extends JpaRepository<Question,Long> {

    Question findBySubjectAndContent(String subject,String content);
    Page<Question> findAll(Pageable pageable);
}
