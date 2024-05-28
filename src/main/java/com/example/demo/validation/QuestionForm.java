package com.example.demo.validation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목을 작성해주세요.")
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "내용을 작성해주세요.")
    private String content;


}
