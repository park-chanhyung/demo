package com.example.demo.controller;

import com.example.demo.service.DataNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.validation.UserForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("/signup")
    public String signup(UserForm userForm){
        return "signup_form";
    }
    @PostMapping("/signup")
    public String signup(@Valid UserForm userForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "signup_form";
        }
        if (!userForm.getPassword1().equals(userForm.getPassword2())){
            bindingResult.rejectValue("password2","passworInCorrect","2개의 패스워드가 일치하지않습니다.");
            return "signup_form";
        }
        try{
        userService.create(userForm.getUsername(),userForm.getEmail(),userForm.getPassword1());
        }catch (DataIntegrityViolationException e){
                e.printStackTrace();
                bindingResult.reject("Failed","이미 등록된 사용자입니다.");
                return "signup_form";
        }catch (Exception e){
            e.printStackTrace();
            bindingResult.reject("signedFailed",e.getMessage());
            return "signup_form";
        }
        return "redirect:/";

    }

    @GetMapping("/login")
    public String login(){
        return "login_form";
    }

}
